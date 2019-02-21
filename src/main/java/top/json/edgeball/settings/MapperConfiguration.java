package top.json.edgeball.settings;

import org.apache.catalina.User;
import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.json.edgeball.domain.repo.UserMapper;

import javax.sql.DataSource;

@Configuration
public class MapperConfiguration {
    @Autowired
    SqlSessionFactory factory;

    @Bean
    public MapperFactoryBean<UserMapper> userMapperMapperFactoryBean() {
        MapperFactoryBean<UserMapper> mapperFactoryBean = new MapperFactoryBean<>();
        mapperFactoryBean.setMapperInterface(UserMapper.class);
        mapperFactoryBean.setSqlSessionFactory(factory);
        return mapperFactoryBean;
    }

}
