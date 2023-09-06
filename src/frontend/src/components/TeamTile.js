import { React} from 'react';
import { IPLTeamName } from '../constants/IPLTeamName';
import { Link } from 'react-router-dom';

import './TeamTile.scss';

export const TeamTile =  ({teamName}) => {

    return (
        <div className="TeamTile">
            <h1>
                <Link to={`/teams/${teamName}`}>{IPLTeamName[teamName]}</Link>
            </h1>
        </div>
    )
}