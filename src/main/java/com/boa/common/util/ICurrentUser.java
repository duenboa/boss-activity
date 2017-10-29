package com.boa.common.util;

import java.io.Serializable;

public interface ICurrentUser<ID extends Serializable> {
    ID getCurrentUserID();
}
