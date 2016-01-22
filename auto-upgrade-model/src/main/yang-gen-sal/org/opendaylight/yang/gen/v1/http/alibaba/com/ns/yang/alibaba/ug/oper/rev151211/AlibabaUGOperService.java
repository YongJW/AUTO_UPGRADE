package org.opendaylight.yang.gen.v1.http.alibaba.com.ns.yang.alibaba.ug.oper.rev151211;
import org.opendaylight.yangtools.yang.binding.RpcService;
import org.opendaylight.yangtools.yang.common.RpcResult;
import java.util.concurrent.Future;


/**
 * Interface for implementing the following YANG RPCs defined in module &lt;b&gt;Alibaba-UG-oper&lt;/b&gt;
 * &lt;br&gt;(Source path: &lt;i&gt;META-INF\yang\Alibaba-UG-oper.yang&lt;/i&gt;):
 * &lt;pre&gt;
 * rpc shutdown-all {
 *     status CURRENT;
 * }
 * rpc upgrade {
 *     status CURRENT;
 * }
 * &lt;/pre&gt;
 *
 */
public interface AlibabaUGOperService
    extends
    RpcService
{




    Future<RpcResult<java.lang.Void>> shutdownAll();
    
    Future<RpcResult<java.lang.Void>> upgrade();

}

