package com.linln.modules.gateway.repository;

import com.linln.modules.gateway.domain.Memu;
import com.linln.modules.system.repository.BaseRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author chenmm
 * @date 2019/10/30
 */
public interface MemuRepository extends BaseRepository<Memu, Long> {
    /**
     * create by: chenmm
     * description: 根据pid查询并排序
     * create time: 2019/10/30 4:01
     * @Param: null
     * @return
     */
    public List<Memu> findByPid(Sort sort, long pid);

    /**
     * @params
     * @Description 查询一级菜单  <br/>
     * @return
     * @author chenmoumou
     * @createTime 2019/10/21 15:58
     */
    @Query(value = "select * from gateway_memu where pid is null order by sort ",nativeQuery = true)
    List<Memu> findAllOneLevel();

    /**
     * @params
     * @Description TODO  <br/>
     * @return
     * @author chenmoumou
     * @createTime 2019/10/21 15:59
     */
    @Query(value = "select * from gateway_memu where pid is not null order by sort ",nativeQuery = true)
    List<Memu> findAllTwoLevel();
}