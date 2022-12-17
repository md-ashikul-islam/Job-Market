package com.ashik.jobmarket.services.implementation;

import com.ashik.jobmarket.exceptions.ResourceNotFoundException;
import com.ashik.jobmarket.model.Post;
import com.ashik.jobmarket.model.User;
import com.ashik.jobmarket.payloads.PostDTO;
import com.ashik.jobmarket.payloads.PostResponse;
import com.ashik.jobmarket.repository.PostRepository;
import com.ashik.jobmarket.repository.UserRepository;
import com.ashik.jobmarket.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepo;

    @Override
    public PostDTO createPost(PostDTO postDTO, Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","User Id",userId));
        Post post = this.modelMapper.map(postDTO,Post.class);
        post.setAddedDate(new Date());
        post.setUser(user);
        Post newPost= this.postRepo.save(post);

        return this.modelMapper.map(newPost, PostDTO.class);
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, Integer postId) {
        Post post = this.postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post ", "post id", postId));


        post.setProfile(postDTO.getProfile());
        post.setDescription(postDTO.getDescription());
        post.setExperience(postDTO.getExperience());
        post.setTechs(post.getTechs());


        Post updatedPost = this.postRepo.save(post);
        return this.modelMapper.map(updatedPost, PostDTO.class);

    }

    @Override
    public void deletePost(Integer postId) {
        Post post = this.postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post ", "post id", postId));

        this.postRepo.delete(post);

    }

    @Override
    public PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
        Sort sort = (sortDir.equalsIgnoreCase("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable p = PageRequest.of(pageNumber, pageSize, sort);

        Page<Post> pagePost = this.postRepo.findAll(p);

        List<Post> allPosts = pagePost.getContent();

        List<PostDTO> postDtos = allPosts.stream().map((post) -> this.modelMapper.map(post, PostDTO.class))
                .collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();

        postResponse.setContent(postDtos);
        postResponse.setPageNumber(pagePost.getNumber());
        postResponse.setPageSize(pagePost.getSize());
        postResponse.setTotalElements(pagePost.getTotalElements());

        postResponse.setTotalPages(pagePost.getTotalPages());
        postResponse.setLastPage(pagePost.isLast());

        return postResponse;
    }

    @Override
    public PostDTO getPostById(Integer postId) {
        Post post = this.postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "post id", postId));
        return this.modelMapper.map(post, PostDTO.class);
    }

    @Override
    public List<PostDTO> getPostsByUser(Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User ", "userId ", userId));
        List<Post> posts = this.postRepo.findAllByUser(user);

        List<PostDTO> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDTO.class))
                .collect(Collectors.toList());

        return postDtos;
    }

    @Override
    public List<PostDTO> searchPost(String keyword) {
        List<Post> posts = this.postRepo.searchByTitle("%" + keyword + "%");
        List<PostDTO> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDTO.class)).collect(Collectors.toList());
        return postDtos;

    }
}
