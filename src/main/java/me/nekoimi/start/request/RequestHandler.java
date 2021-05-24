package me.nekoimi.start.request;

import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;

/**
 * @author nekoimi  2021/3/2 下午4:19
 */
public interface RequestHandler {
    FullHttpResponse handle(FullHttpRequest request);
}
