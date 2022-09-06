// 该文件专门用于创建整个应用的路由器
import VueRouter from 'vue-router'
//引入路由组件
import Home from "../pages/Home"
import Latest from "../pages/Latest";
import Login from "../pages/Login";
import Register from "../pages/Register";
import Comment from "../pages/Comment";
import User from "../pages/User";
import Edit from "../pages/Edit";
import Publish from "../pages/Publish";

export default new VueRouter({
    routes:[
        {
            name:'home',
            path:'/home',
            component:Home,
        },
        {
            name:'latest',
            path:'/latest',
            component:Latest
        },
        {
            name:'login',
            path:'/login',
            component:Login
        },
        {
            name:'register',
            path:'/register',
            component:Register
        },
        {
            name:'comment',
            path:'/comment',
            component:Comment
        },
        {
            name:'user',
            path:'/user',
            component:User,
            children:[
                {
                    path:'edit',
                    component:Edit
                }
            ]
        },
        {
            name:'publish',
            path:'/publish',
            component:Publish
        }
    ]
})