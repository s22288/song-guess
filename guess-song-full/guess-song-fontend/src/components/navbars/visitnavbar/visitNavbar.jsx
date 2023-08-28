import { Link } from "react-router-dom"
import './visitnav.css'
import { ReactComponent as YourSvg } from '../../../resources/menu.svg';

const VisitNavbar = () => {
    return (
        <div className="visitnav">
            <ol>
                <li>
                    <a href="#"><YourSvg /></a>

                    <ul>
                        <li><Link>About</Link></li>
                        <li><Link>Create Account</Link></li>
                        <li><Link to="user-page" >Login</Link></li>
                        {/* <li><a href="#">About</a></li>
                        <li><a href="#">Create Account</a></li>
                        <li><a href="#">Login in</a></li> */}

                    </ul>
                </li>


            </ol>
        </div>
    )
}
export default VisitNavbar