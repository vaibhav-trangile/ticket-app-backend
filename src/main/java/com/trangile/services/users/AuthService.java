package com.trangile.services.users;

import com.trangile.ui.req.dto.LoginDto;
import com.trangile.ui.res.dto.AuthResponse;

public interface AuthService {
	AuthResponse validateAndGenerateToken(LoginDto dto);
}
