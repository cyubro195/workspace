import { Link, useNavigate } from "react-router-dom"




const Board = ({board}) => {

  const naviate = useNavigate();

  return (
    <tr>
      <td>{board.boardNum}</td>
      <td>
        <Link to='/detail'></Link>
        {board.title}
      </td>
      <td>{board.writer}</td>
      <td>{board.createDate}</td>
    </tr>

  );
}

export default Board;