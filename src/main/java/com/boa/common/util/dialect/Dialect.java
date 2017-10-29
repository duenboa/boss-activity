package com.boa.common.util.dialect;

import com.boa.common.util.pagination.Page;

public interface Dialect {
    String pageSql(String sql, Page page);
}
