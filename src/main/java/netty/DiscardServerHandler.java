/**
 * FileName: DiscardServerHandler
 * Author:   Administrator
 * Date:     2019/6/4 13:58
 * Description:
 */
package netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf msg1 = (ByteBuf) msg;
        try {
            while (msg1.isReadable()){
                byte b = msg1.readByte();
                byte[] bs = {b};
                String s = new String(bs,"gbk");
                System.out.println(b);
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }
}
