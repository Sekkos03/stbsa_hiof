import React, {useState} from 'react';
import Calendar from 'react-calendar';

function GuideMainPage(){

    const [date, setDate] = useState(new Date());

    return(
        <div>
            <h1>Guide Main Page</h1>
            <div className='calender'>
                <h1 className='text-center'>React Calendar</h1>
                <div className='calendar-container'>
                    <Calendar onChange={setDate} value={date} />
                </div>
                <p className='text-center'>
                    <span className='bold'>Selected Date:</span>{' '}
                    {date.toDateString()}
                </p>
            </div>
        </div>
    )
}

export default GuideMainPage