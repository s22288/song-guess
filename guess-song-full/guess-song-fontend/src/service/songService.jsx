 async function GetAllSongs (){
    const response = await fetch("http://localhost:8081/api/songs");
    const songs = await response.json();
 return songs
}

export default GetAllSongs