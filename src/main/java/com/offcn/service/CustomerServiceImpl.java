package com.offcn.service;

import java.util.List;
import com.offcn.mapper.CustomerMapper;
import com.offcn.pojo.Customer;
import com.offcn.utils.SerializeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private JedisPool jedisPool;

	@Autowired
	private CustomerMapper customerMapper;
	
	@Override
	public List<Customer> getCustomerList() {
		List<Customer> list=customerMapper.getCustomerList();
		return list;
	}

	@Override
	public void saveCustomer(Customer c) {
		customerMapper.saveCustomer(c);
	}

	@Override
	public List<Customer> getCustomerListByName(String job) {
        Jedis jedis = jedisPool.getResource();
        byte[] key = job.getBytes();
        Boolean flag = jedis.exists(key);
        if (flag) {
            byte[] list = jedis.get(key);
            List<Customer> customerList=(List<Customer>)SerializeUtil.unserialize(list);
            System.out.println("redis");
            return customerList;

        } else {
            List<Customer> customerList=customerMapper.getCustomerListByName("%" + job + "%");
            byte[] value = SerializeUtil.serialize(customerList);
            jedis.set(key, value);
            System.out.println("mysql");
            return customerList;
        }
    }
}
