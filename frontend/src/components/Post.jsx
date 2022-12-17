import React from 'react'
import { useEffect } from 'react'
import { useContext } from 'react'
import { useState } from 'react'
import { Link } from 'react-router-dom'
import { Button, Card, CardBody, CardText } from 'reactstrap'
import { getCurrentUserDetail, isLoggedIn } from '../auth'
import userContext from '../context/userContext'
function Post({ post = { id: -1, profile: "This is default post title", description: "This is default post content" }, deletePost }) {

    const userContextData = useContext(userContext)
    const [user, setUser] = useState(null)
    const [login, setLogin] = useState(null)
    useEffect(() => {
        setUser(getCurrentUserDetail())
        setLogin(isLoggedIn())
    }, [])
    return (


        <Card className='border-0 shadow-sm mt-3'>
            <CardBody>
                <h3>{post.profile}</h3>
                <CardText dangerouslySetInnerHTML={{ __html: post.description.substring(0, 70) + "...." }}>

                </CardText>

                <div>
                    <Link className='btn btn-secondary border-0' to={'/posts/' + post.postId}>Read More</Link>
                    {userContextData.user.login && (user && user.id === post.user.id ? <Button onClick={(event) => deletePost(post)} color='danger' className="ms-2">Delete</Button> : '')}
                    {userContextData.user.login && (user && user.id === post.user.id ? <Button tag={Link} to={`/user/update-post/${post.postId}`} color='warning' className="ms-2">Update</Button> : '')}

                </div>
            </CardBody>
        </Card>

    )
}

export default Post