package com.assigmnet.parameterPrinterdemo.parameter.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 */
@Component
public class TimerServer {

    @Autowired ParameterSender sender;
    static final Logger logger = LoggerFactory.getLogger(TimerServer.class);
    Parameter parameter =  new Parameter(0);

    @Scheduled(fixedDelay = 3456000) //period value = 0.04 days= 0.04*24*60*60*1000miliseconds
    public void calculateDaysLeft(){

        Calendar startCal = Calendar.getInstance();
        int currentDayOfYear = startCal.get(Calendar.DAY_OF_YEAR);

        int year = startCal.get(Calendar.YEAR);

        Calendar endCal = new GregorianCalendar(year, 11, 31);
        int dayDecember31 = endCal.get(Calendar.DAY_OF_YEAR);

        double daysLeft = dayDecember31 - currentDayOfYear;
        logger.info(daysLeft + " days remain in current year");
        logger.info("Current time "+startCal.getTime());
        endCal.set(Calendar.MONTH, 11); // 11 = december
        endCal.set(Calendar.DAY_OF_MONTH, 31); // new years eve
        double sundays = 0;
        double saturdays=0;

        //Return 0 if start and end are the same
        if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
          logger.info("It is last day of the year");
        }


        do {
            //excluding start date
            startCal.add(Calendar.DAY_OF_MONTH, 1);
            if (startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                ++sundays;
            }
            if (startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                ++saturdays;
            }
        } while (startCal.getTimeInMillis() < endCal.getTimeInMillis()); //excluding end date

       logger.info("Sundays="+sundays);
        logger.info("Saturdays="+saturdays);
        daysLeft=daysLeft-sundays-saturdays;
        sundays=sundays*0.5;
        saturdays=saturdays*0.75;
        daysLeft=daysLeft+saturdays+sundays;
        this.parameter.setDaysLeft(daysLeft);
        sender.sendParameter(this.parameter); //sending alarm to all parties listening to queue
        logger.info("Alarm for 0.04 days elapsed!!!!");
}


}
