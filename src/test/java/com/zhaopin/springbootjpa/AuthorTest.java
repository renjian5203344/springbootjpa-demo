package com.zhaopin.springbootjpa;

import com.alibaba.fastjson.JSON;
import com.zhaopin.springbootjpa.dataobject.Author;
import com.zhaopin.springbootjpa.dataobject.Wallet;
import com.zhaopin.springbootjpa.repository.AuthorRepository;
import com.zhaopin.springbootjpa.repository.WalletRepository;
import com.zhaopin.springbootjpa.service.AuthorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorTest {

@Autowired
private AuthorRepository authorRepository;

@Autowired
private WalletRepository walletRepository;
@Autowired
private AuthorService authorService;

@Test
    public void  saveAuthorTest(){
        Author author = new Author();
        author.setNickName("test");
        author.setPhone("18217687652");
        author.setSingnDate(new Date());
        author.setWallet(new Wallet(new BigDecimal(188.23)));
       authorRepository.save(author);

    }

    @Test
    public void updateAuthor(){
    Author author = authorService.findAuthor(25L);
    author.setPhone("18700000000");
    Wallet wallet = author.getWallet();
    wallet.setBalance(new BigDecimal(288.88));
    author.setWallet(wallet);
    authorService.updateAuthor(author);


    }










    @Test
    public void findAuthorTest(){
//        List<Author> authors = authorRepository.findByPhoneAndNickName("13800138000","arvin");
//        List<Author> authors = authorRepository.findDistinctByNickNameIgnoreCaseOrPhoneOrderBySingnDateDesc("林剑","13800138000");
//          List<Author> authors = authorRepository.findByNickNameLike("%林%");
//        List<Author> authors = authorRepository.findByPhone("%8%");//查询包含8
//           List<Author> authors = authorRepository.findByPhone("%8");//查询尾号是8
//        List<Author> authors = authorRepository.findByPhone("01");//查询包含01
//        List<Object[]> arry = authorRepository.findArry("林");//查询昵称包含姓林的
//        Sort sort = new Sort(Sort.Direction.DESC,"singnDate");
//        List<Author> authors = authorRepository.findByNickName("林",sort);
//          List<Author> authors = authorRepository.findByPhone("39");//调用另外一种传参方式
//        List<Author> authors = authorRepository.findsql("林");
//        int i = authorRepository.setNickName("kitty","13800138002");

          Author author = authorService.findAuthor(25L);
        System.out.println(JSON.toJSONString(author,true));


       // System.out.println(JSON.toJSONString(authors,true));

    }

    @Test
    public void deleteAuthorTest(){
    authorService.deleteAuthor(27L);
    }

    @Test
    public void findAuthorForPageTest(){
       Sort sort = new Sort(Sort.Direction.DESC,"id");
       Pageable pageable = new PageRequest(1,5,sort);
       Page<Author> page =authorRepository.findAll(pageable);
        System.out.println(JSON.toJSONString(page,true));

    }
    @Test
    public void transactionalTest(){
    authorService.updateAuthor();


    }

    @Test
    public void findWalletTest(){
    Wallet wallet = walletRepository.findById(30L).get();
        System.out.println(JSON.toJSONString(wallet,true));

    }

}
