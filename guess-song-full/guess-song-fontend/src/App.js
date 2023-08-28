import { Route, Routes } from "react-router";
import VisitPage from "./routes/vistpageRoute/visitPage";
import UserPage from "./routes/userRoute/userPage";
import GamePage from "./routes/gameRoute/gameRoute";


function App() {
  return (
    <div>
    <Routes>
    <Route path='/' element={<VisitPage />}></Route>
    <Route path='/user-page/game-page' element={<GamePage />}></Route>

    <Route path='/user-page' element={<UserPage />}></Route>

    </Routes>
    </div>
  );
}

export default App;
