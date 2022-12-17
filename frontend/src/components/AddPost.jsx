import { useState } from "react"
import { useEffect } from "react"
import { Card, CardBody, Form, Input, Label, Button, Container } from "reactstrap"
import { getCurrentUserDetail } from "../auth"
import { useRef } from "react"
import { createPost as doCreatePost, uploadPostImage } from "../services/post-service"
import { toast } from "react-toastify"
const AddPost = () => {

    // const [content,setContent] =useState('')
    const [user, setUser] = useState(undefined)

    const [post, setPost] = useState({
        profile: '',
        description: '',
        experience:'',
        techs: '',
        
    })

    useEffect(
        () => {

            setUser(getCurrentUserDetail())
        },
        []
    )

    //field changed function
    const fieldChanged = (event) => {
        // console.log(event)
        setPost({ ...post, [event.target.name]: event.target.value })
    }




    //create post function
    const createPost = (event) => {

        event.preventDefault();

        // console.log(post)
        if (post.profile.trim() === '') {
            toast.error("Job title is required !!")
            return;
        }

        if (post.description.trim() === '') {
            toast.error("job description is required !!")
            return
        }
        if (post.experience.trim() === '') {
            toast.error("Experience is required !!")
            return
        }
        if (post.techs.trim() === '') {
            toast.error("Tech stack is required !!")
            return
        }



        //submit the form one server
        post['userId'] = user.id
        doCreatePost(post).then(data => {

            toast.success("Job Post Created !!")
            console.log(data)
            setPost({
                profile: '',
                description: '',
                experience:'',
                techs: ''
            })
        }).catch((error) => {
            toast.error("Job Post not created due to some error !!")
            console.log(error)
        })

    }



    return (
        <div className="wrapper">
            <Card className="shadow-sm  border-0 mt-2">
                <CardBody>
                    {/* {JSON.stringify(post)} */}
                    <h3>What going in your mind ?</h3>
                    <Form onSubmit={createPost}>
                        <div className="my-3">
                            <Label for="profile" >Job title</Label>
                            <Input
                                type="text"
                                id="profile"
                                placeholder="Enter here"
                                className="rounded-0"
                                name="profile"
                                onChange={fieldChanged}
                            />
                        </div>

                        <div className="my-3">
                            <Label for="description" >Post Content</Label>
                            <Input
                                type="textarea"
                                id="description"
                                placeholder="Enter here"
                                Name="description"
                                style={{ height: '300px' }}
                                onChange={fieldChanged}
                            />
                            </div>
                            <div className="my-3">
                            <Label for="techs" >Tech Stack</Label>
                            <Input
                                type="textarea"
                                id="techs"
                                placeholder="Enter here"
                                Name="techs"
                                onChange={fieldChanged}
                                
                            />

                            {/* <JoditEditor
                                ref={editor}
                                value={post.description}

                                onChange={(newContent) => contentFieldChanaged(newContent)}
                            /> */}
                        </div>
                        <div  className="my-3">
                        <select className="form-select" aria-label="Default select example" id="experince" name="experience" onChange={fieldChanged}>
                         <option selected>How many years of experience needed?</option>
                        <option value="1">0</option>
                        <option value="2">1</option>
                        <option value="3">2</option>
                        <option value="4">3</option>
                        </select>
                        </div>


                        <Container className="text-center">
                            <Button type="submit" className="rounded-0" color="primary">Create Post</Button>
                            <Button className="rounded-0 ms-2" color="danger">Reset Content</Button>
                        </Container>
                    </Form>
                </CardBody>
            </Card>




        </div>
    )
}

export default AddPost