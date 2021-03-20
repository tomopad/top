/*
 * Copyright (c) 2020 pig4cloud Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tomopad.top.common.core.exception;

import lombok.NoArgsConstructor;

/**
 * @date  403 授权拒绝
 */
@NoArgsConstructor
public class TopDeniedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TopDeniedException(String message) {
		super(message);
	}

	public TopDeniedException(Throwable cause) {
		super(cause);
	}

	public TopDeniedException(String message, Throwable cause) {
		super(message, cause);
	}

	public TopDeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
