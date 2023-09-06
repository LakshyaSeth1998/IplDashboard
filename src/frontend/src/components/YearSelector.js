import { React } from 'react';
import { Link } from 'react-router-dom';

import './YearSelector.scss';

export const YearSelector =  ({teamName}) => {
    const startYear = parseInt(process.env.REACT_APP_DATA_START_YEAR,10);
    const endYear = parseInt(process.env.REACT_APP_DATA_END_YEAR,10);
    let years = [];
    for(let i=startYear;i<=endYear ;i++){
        years.push(i);
    }

    return (
        <ol className='YearSelector'>
            <h3>Select Year</h3>
            { years.map(year => 
                (
                <li key={year}>
                    <Link to={`/teams/${teamName}/matches/${year}`}>{year}</Link>
                </li>
                )
            )
            }
        </ol>
    )
}