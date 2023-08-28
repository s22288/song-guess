import { Link } from "react-router-dom"
import UserAppBar from "../../components/navbars/userNavbar/userNavbar"

import './userPage.css'
import { Button, Menu, MenuItem } from "@mui/material"
const UserPage = () => {

    return (

        <div>
            <UserAppBar />
          <div className="centergame">
            <Link to="game-page" className="gameText"  >Play game</Link>

          </div>
        </div>
    )
}

export default UserPage