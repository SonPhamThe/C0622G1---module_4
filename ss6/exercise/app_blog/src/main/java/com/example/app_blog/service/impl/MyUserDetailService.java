//package com.example.app_blog.service.impl;
//
//import com.example.app_blog.model.MyUserDetail;
//import com.example.app_blog.model.User;
//import com.example.app_blog.repository.IUserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//
//@Service
//@Transactional
//// là 1 tiến trình có điểm đầu và diểm cuối, nếu 1 giai đoạn trong tiến trình mà sai thì nó sẽ rolback lại từ đầu
//public class MyUserDetailService implements UserDetailsService {
//
//    @Autowired
//    private IUserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User Name " + user.getUsername() + " not found");
//        }
//        return new MyUserDetail(user);
//    }
//}
