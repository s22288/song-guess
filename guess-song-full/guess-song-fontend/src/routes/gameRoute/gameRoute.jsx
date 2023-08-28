import { useEffect } from "react";
import GetAllSongs from "../../service/songService";
import { useState } from "react";
import './gameRoute.css'
import UserAppBar from "../../components/navbars/userNavbar/userNavbar";
import { Button } from "@mui/material";
import GameNavbar from "../../components/navbars/gameNavbar/gameNavbar";

const GamePage = () => {

    const [audioPath, SetAudioPath] = useState("");

    const [songs, setSongs] = useState("")
    const [score, setScore] = useState(0);
    const [song, SetSong] = useState("");
    const [finished, SetFinished] = useState("false");
    const [songNumber, SetSongNumber] = useState(0)
    const [blurred, setBlurred] = useState("true")
    const UnBlured = () => {
        setBlurred(!blurred)
    }
    const start = () => {
        console.log(audioPath)
        const myButton = document.getElementById('b1');
        const myButton2 = document.getElementById('b2');
        const myButton3 = document.getElementById('b3');

        let audio = new Audio("/songs/" + audioPath);

        audio.play()
        audio.addEventListener('ended', () => {
            console.log("Audio has finished playing");
            SetFinished("true")
myButton.disabled = false;
myButton2.disabled = false;
myButton3.disabled = false;

        });

    }
    useEffect(() => {
        const fetchData = async () => {
            try {
                const fetchedSongs = await GetAllSongs();
                console.log(fetchedSongs)
                setSongs(fetchedSongs);
                SetAudioPath(fetchedSongs[0].correctSong.mp3_path)
            } catch (error) {
                console.error('Error fetching songs:', error);
            }
        };
        fetchData();
    }, [])

    const handleInput = (e) => {
        let option = e.target.value;
        if (option == songs[songNumber].correctSong.name) {
            UnBlured()

            setTimeout(() => {
                let updatedNumber = songNumber + 1;
                SetSongNumber(updatedNumber)
                  setBlurred(blurred)
                SetAudioPath(songs[updatedNumber].correctSong.mp3_path)
                
    
            }, 5000); 
           
            setScore(score + 1)
            if(score==3){
                alert('you win')
                window.location.reload();

            }
          
            

         
        } else {
            alert('you lose')
            setScore(0)
            window.location.reload();


        }
    }


    return (
        <div>
            <GameNavbar />

            <h2 className="gamePhoto">Score : {score}</h2>
            <div className="outer" >
                <div className="inner">
                    <div className="gamePhoto">

                        {songs[songNumber] && <img src={songs[songNumber].correctSong.photo} className={blurred ? "songimg" : "songimgbluredoff"} />}

                    </div>
                    <div className="gameName">

                        {songs[songNumber] && <h2 className={blurred ? "songimg" : "songimgbluredoff"}>{songs[songNumber].correctSong.name}</h2>}

                    </div>
                    <div className="gamePhoto">


                        {songs[songNumber] && <h2>{songs[songNumber].name}</h2>}
                    </div>
                    < div className="playbutton">
                        <button className="runSong" onClick={start}>Play</button>
                    </div >

                    <div className="anserws">

                        {songs[songNumber] && <button id="b1"  className="highlight-button" value={songs[songNumber].correctSong.name} onClick={e => handleInput(e, "value")}>{songs[songNumber].correctSong.name}</button>}
                        {songs[songNumber] && <button id="b2" className="highlight-button" value={songs[songNumber].alternatives[0]} onClick={e => handleInput(e, "value2")}>{songs[songNumber].alternatives[0]}</button>}
                        {songs[songNumber] && <button id="b3"  className="highlight-button" value={songs[songNumber].alternatives[1]} onClick={e => handleInput(e, "value3")}>{songs[songNumber].alternatives[1]}</button>}

                    </div>

                </div>

            </div>



        </div>

    )
}
export default GamePage;