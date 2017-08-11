package com.kinslau.springBoot.Test.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.sctp.nio.NioSctpServerChannel;

import java.net.InetSocketAddress;

/**
 * Created by 刘 辉 on 2017/8/9.
 */
public class EchoServer {
    private final int port = 1993;



    public static void main(String[] args) throws Exception{

        if (args.length != 1){
            System.out.println("Usage: "+EchoServer.class.getSimpleName()+"");
        }

        int port = 1993;
        new EchoServer().start();

    }




    public void start() throws Exception{
        final EchoServerHandler serverHandler = new EchoServerHandler();
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(group).channel(NioSctpServerChannel.class).localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer() {

                        @Override
                        protected void initChannel(Channel channel) throws Exception {
                            channel.pipeline().addLast(serverHandler);
                        }
                    });
            ChannelFuture f = b.bind().sync();
            f.channel().closeFuture().sync();

        }
        finally {
            group.shutdownGracefully().sync();
        }

    }

}
