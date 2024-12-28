import { Outlet } from "react-router-dom";

const ManagerLayout = () => {
    return ( 
        <div className="managerLayout">
            <div>Manager layout</div>
            <Outlet/>
        </div>
     );
}
 
export default ManagerLayout;