import logo from './logo.svg';
import './App.css';

function App() {
  return (
    // jsx, html 아님니두!
    <div className="App">
      <Mytable></Mytable>
    </div>
  );
}

//컴포넌트 
function Mytable(){
  return(
    <table border= "1">
      <tr>
        <td>이름</td>
        <td>나이</td>
      </tr>
    </table>
  );
}



export default App;
