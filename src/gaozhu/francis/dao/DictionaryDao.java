package gaozhu.francis.dao;

import gaozhu.francis.entity.Dictionary;

import java.util.List;

public interface DictionaryDao
{

    List<Dictionary> getAll();

    /**
     * 跟据分组获取字典内容
     * @param group
     * @return
     */
    List<Dictionary> getByGroup(String group);


}
