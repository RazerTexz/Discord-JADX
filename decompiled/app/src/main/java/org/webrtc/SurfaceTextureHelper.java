package org.webrtc;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.Nullable;
import java.util.concurrent.Callable;
import org.webrtc.EglBase;
import org.webrtc.TextureBufferImpl;
import org.webrtc.VideoFrame;
import p007b.p100d.p104b.p105a.outline;
import p617h0.p628c.C12484r;
import p617h0.p628c.EglBase2;
import p617h0.p628c.RunnableC12486s;
import p617h0.p628c.RunnableC12488t;
import p617h0.p628c.RunnableC12490u;
import p617h0.p628c.RunnableC12492v;
import p617h0.p628c.RunnableC12493w;
import p617h0.p628c.RunnableC12494x;

/* loaded from: classes3.dex */
public class SurfaceTextureHelper {
    private static final String TAG = "SurfaceTextureHelper";
    private final EglBase eglBase;
    private final FrameRefMonitor frameRefMonitor;
    private int frameRotation;
    private final Handler handler;
    private boolean hasPendingTexture;
    private boolean isQuitting;
    private volatile boolean isTextureInUse;

    @Nullable
    private VideoSink listener;
    private final int oesTextureId;

    @Nullable
    private VideoSink pendingListener;
    public final Runnable setListenerRunnable;
    private final SurfaceTexture surfaceTexture;
    private int textureHeight;
    private final TextureBufferImpl.RefCountMonitor textureRefCountMonitor;
    private int textureWidth;

    @Nullable
    private final TimestampAligner timestampAligner;
    private final YuvConverter yuvConverter;

    /* renamed from: org.webrtc.SurfaceTextureHelper$1 */
    public class CallableC129861 implements Callable<SurfaceTextureHelper> {
        public final /* synthetic */ boolean val$alignTimestamps;
        public final /* synthetic */ FrameRefMonitor val$frameRefMonitor;
        public final /* synthetic */ Handler val$handler;
        public final /* synthetic */ EglBase.Context val$sharedContext;
        public final /* synthetic */ String val$threadName;
        public final /* synthetic */ YuvConverter val$yuvConverter;

        public CallableC129861(EglBase.Context context, Handler handler, boolean z2, YuvConverter yuvConverter, FrameRefMonitor frameRefMonitor, String str) {
            this.val$sharedContext = context;
            this.val$handler = handler;
            this.val$alignTimestamps = z2;
            this.val$yuvConverter = yuvConverter;
            this.val$frameRefMonitor = frameRefMonitor;
            this.val$threadName = str;
        }

        @Override // java.util.concurrent.Callable
        @Nullable
        public /* bridge */ /* synthetic */ SurfaceTextureHelper call() throws Exception {
            return call2();
        }

        @Override // java.util.concurrent.Callable
        @Nullable
        /* renamed from: call, reason: avoid collision after fix types in other method */
        public SurfaceTextureHelper call2() {
            try {
                return new SurfaceTextureHelper(this.val$sharedContext, this.val$handler, this.val$alignTimestamps, this.val$yuvConverter, this.val$frameRefMonitor, null);
            } catch (RuntimeException e) {
                Logging.m11029e(SurfaceTextureHelper.TAG, this.val$threadName + " create failure", e);
                return null;
            }
        }
    }

    /* renamed from: org.webrtc.SurfaceTextureHelper$2 */
    public class C129872 implements TextureBufferImpl.RefCountMonitor {
        public C129872() {
        }

        @Override // org.webrtc.TextureBufferImpl.RefCountMonitor
        public void onDestroy(TextureBufferImpl textureBufferImpl) {
            SurfaceTextureHelper.access$200(SurfaceTextureHelper.this);
            if (SurfaceTextureHelper.access$100(SurfaceTextureHelper.this) != null) {
                SurfaceTextureHelper.access$100(SurfaceTextureHelper.this).onDestroyBuffer(textureBufferImpl);
            }
        }

        @Override // org.webrtc.TextureBufferImpl.RefCountMonitor
        public void onRelease(TextureBufferImpl textureBufferImpl) {
            if (SurfaceTextureHelper.access$100(SurfaceTextureHelper.this) != null) {
                SurfaceTextureHelper.access$100(SurfaceTextureHelper.this).onReleaseBuffer(textureBufferImpl);
            }
        }

        @Override // org.webrtc.TextureBufferImpl.RefCountMonitor
        public void onRetain(TextureBufferImpl textureBufferImpl) {
            if (SurfaceTextureHelper.access$100(SurfaceTextureHelper.this) != null) {
                SurfaceTextureHelper.access$100(SurfaceTextureHelper.this).onRetainBuffer(textureBufferImpl);
            }
        }
    }

    /* renamed from: org.webrtc.SurfaceTextureHelper$3 */
    public class RunnableC129883 implements Runnable {
        public RunnableC129883() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder sbM833U = outline.m833U("Setting listener to ");
            sbM833U.append(SurfaceTextureHelper.access$300(SurfaceTextureHelper.this));
            Logging.m11027d(SurfaceTextureHelper.TAG, sbM833U.toString());
            SurfaceTextureHelper surfaceTextureHelper = SurfaceTextureHelper.this;
            SurfaceTextureHelper.access$402(surfaceTextureHelper, SurfaceTextureHelper.access$300(surfaceTextureHelper));
            SurfaceTextureHelper.access$302(SurfaceTextureHelper.this, null);
            if (SurfaceTextureHelper.access$500(SurfaceTextureHelper.this)) {
                SurfaceTextureHelper.access$600(SurfaceTextureHelper.this);
                SurfaceTextureHelper.access$502(SurfaceTextureHelper.this, false);
            }
        }
    }

    public interface FrameRefMonitor {
        void onDestroyBuffer(VideoFrame.TextureBuffer textureBuffer);

        void onNewBuffer(VideoFrame.TextureBuffer textureBuffer);

        void onReleaseBuffer(VideoFrame.TextureBuffer textureBuffer);

        void onRetainBuffer(VideoFrame.TextureBuffer textureBuffer);
    }

    public /* synthetic */ SurfaceTextureHelper(EglBase.Context context, Handler handler, boolean z2, YuvConverter yuvConverter, FrameRefMonitor frameRefMonitor, CallableC129861 callableC129861) {
        this(context, handler, z2, yuvConverter, frameRefMonitor);
    }

    public static /* synthetic */ FrameRefMonitor access$100(SurfaceTextureHelper surfaceTextureHelper) {
        return surfaceTextureHelper.frameRefMonitor;
    }

    public static /* synthetic */ void access$200(SurfaceTextureHelper surfaceTextureHelper) {
        surfaceTextureHelper.returnTextureFrame();
    }

    public static /* synthetic */ VideoSink access$300(SurfaceTextureHelper surfaceTextureHelper) {
        return surfaceTextureHelper.pendingListener;
    }

    public static /* synthetic */ VideoSink access$302(SurfaceTextureHelper surfaceTextureHelper, VideoSink videoSink) {
        surfaceTextureHelper.pendingListener = videoSink;
        return videoSink;
    }

    public static /* synthetic */ VideoSink access$402(SurfaceTextureHelper surfaceTextureHelper, VideoSink videoSink) {
        surfaceTextureHelper.listener = videoSink;
        return videoSink;
    }

    public static /* synthetic */ boolean access$500(SurfaceTextureHelper surfaceTextureHelper) {
        return surfaceTextureHelper.hasPendingTexture;
    }

    public static /* synthetic */ boolean access$502(SurfaceTextureHelper surfaceTextureHelper, boolean z2) {
        surfaceTextureHelper.hasPendingTexture = z2;
        return z2;
    }

    public static /* synthetic */ void access$600(SurfaceTextureHelper surfaceTextureHelper) {
        surfaceTextureHelper.updateTexImage();
    }

    public static SurfaceTextureHelper create(String str, EglBase.Context context, boolean z2, YuvConverter yuvConverter, FrameRefMonitor frameRefMonitor) {
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        return (SurfaceTextureHelper) ThreadUtils.invokeAtFrontUninterruptibly(handler, new CallableC129861(context, handler, z2, yuvConverter, frameRefMonitor, str));
    }

    private void release() {
        if (this.handler.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Wrong thread.");
        }
        if (this.isTextureInUse || !this.isQuitting) {
            throw new IllegalStateException("Unexpected release.");
        }
        this.yuvConverter.release();
        GLES20.glDeleteTextures(1, new int[]{this.oesTextureId}, 0);
        this.surfaceTexture.release();
        this.eglBase.release();
        this.handler.getLooper().quit();
        TimestampAligner timestampAligner = this.timestampAligner;
        if (timestampAligner != null) {
            timestampAligner.dispose();
        }
    }

    private void returnTextureFrame() {
        this.handler.post(new RunnableC12494x(this));
    }

    @TargetApi(21)
    private static void setOnFrameAvailableListener(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, Handler handler) {
        surfaceTexture.setOnFrameAvailableListener(onFrameAvailableListener, handler);
    }

    private void tryDeliverTextureFrame() {
        if (this.handler.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Wrong thread.");
        }
        if (this.isQuitting || !this.hasPendingTexture || this.isTextureInUse || this.listener == null) {
            return;
        }
        if (this.textureWidth == 0 || this.textureHeight == 0) {
            Logging.m11031w(TAG, "Texture size has not been set.");
            return;
        }
        this.isTextureInUse = true;
        this.hasPendingTexture = false;
        updateTexImage();
        float[] fArr = new float[16];
        this.surfaceTexture.getTransformMatrix(fArr);
        long timestamp = this.surfaceTexture.getTimestamp();
        TimestampAligner timestampAligner = this.timestampAligner;
        if (timestampAligner != null) {
            timestamp = timestampAligner.translateTimestamp(timestamp);
        }
        TextureBufferImpl textureBufferImpl = new TextureBufferImpl(this.textureWidth, this.textureHeight, VideoFrame.TextureBuffer.Type.OES, this.oesTextureId, RendererCommon.convertMatrixToAndroidGraphicsMatrix(fArr), this.handler, this.yuvConverter, this.textureRefCountMonitor);
        FrameRefMonitor frameRefMonitor = this.frameRefMonitor;
        if (frameRefMonitor != null) {
            frameRefMonitor.onNewBuffer(textureBufferImpl);
        }
        VideoFrame videoFrame = new VideoFrame(textureBufferImpl, this.frameRotation, timestamp);
        this.listener.onFrame(videoFrame);
        videoFrame.release();
    }

    private void updateTexImage() {
        synchronized (EglBase.lock) {
            this.surfaceTexture.updateTexImage();
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m11040a() {
        this.isQuitting = true;
        if (this.isTextureInUse) {
            return;
        }
        release();
    }

    /* renamed from: b */
    public /* synthetic */ void m11041b() {
        this.hasPendingTexture = true;
        tryDeliverTextureFrame();
    }

    /* renamed from: c */
    public /* synthetic */ void m11042c(SurfaceTexture surfaceTexture) {
        if (this.hasPendingTexture) {
            Logging.m11027d(TAG, "A frame is already pending, dropping frame.");
        }
        this.hasPendingTexture = true;
        tryDeliverTextureFrame();
    }

    /* renamed from: d */
    public /* synthetic */ void m11043d() {
        this.isTextureInUse = false;
        if (this.isQuitting) {
            release();
        } else {
            tryDeliverTextureFrame();
        }
    }

    public void dispose() {
        Logging.m11027d(TAG, "dispose()");
        ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new RunnableC12486s(this));
    }

    /* renamed from: e */
    public /* synthetic */ void m11044e(int i) {
        this.frameRotation = i;
    }

    /* renamed from: f */
    public /* synthetic */ void m11045f(int i, int i2) {
        this.textureWidth = i;
        this.textureHeight = i2;
        tryDeliverTextureFrame();
    }

    public void forceFrame() {
        this.handler.post(new RunnableC12490u(this));
    }

    /* renamed from: g */
    public /* synthetic */ void m11046g() {
        this.listener = null;
        this.pendingListener = null;
    }

    public Handler getHandler() {
        return this.handler;
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.surfaceTexture;
    }

    public boolean isTextureInUse() {
        return this.isTextureInUse;
    }

    public void setFrameRotation(int i) {
        this.handler.post(new RunnableC12492v(this, i));
    }

    public void setTextureSize(int i, int i2) {
        if (i <= 0) {
            throw new IllegalArgumentException(outline.m871q("Texture width must be positive, but was ", i));
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException(outline.m871q("Texture height must be positive, but was ", i2));
        }
        this.surfaceTexture.setDefaultBufferSize(i, i2);
        this.handler.post(new RunnableC12488t(this, i, i2));
    }

    public void startListening(VideoSink videoSink) {
        if (this.listener != null || this.pendingListener != null) {
            throw new IllegalStateException("SurfaceTextureHelper listener has already been set.");
        }
        this.pendingListener = videoSink;
        this.handler.post(this.setListenerRunnable);
    }

    public void stopListening() {
        Logging.m11027d(TAG, "stopListening()");
        this.handler.removeCallbacks(this.setListenerRunnable);
        ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new RunnableC12493w(this));
    }

    @Deprecated
    public VideoFrame.I420Buffer textureToYuv(VideoFrame.TextureBuffer textureBuffer) {
        return textureBuffer.toI420();
    }

    private SurfaceTextureHelper(EglBase.Context context, Handler handler, boolean z2, YuvConverter yuvConverter, FrameRefMonitor frameRefMonitor) {
        this.textureRefCountMonitor = new C129872();
        this.setListenerRunnable = new RunnableC129883();
        if (handler.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("SurfaceTextureHelper must be created on the handler thread");
        }
        this.handler = handler;
        this.timestampAligner = z2 ? new TimestampAligner() : null;
        this.yuvConverter = yuvConverter;
        this.frameRefMonitor = frameRefMonitor;
        EglBase eglBaseM10663b = EglBase2.m10663b(context, EglBase.CONFIG_PIXEL_BUFFER);
        this.eglBase = eglBaseM10663b;
        try {
            eglBaseM10663b.createDummyPbufferSurface();
            eglBaseM10663b.makeCurrent();
            int iGenerateTexture = GlUtil.generateTexture(36197);
            this.oesTextureId = iGenerateTexture;
            SurfaceTexture surfaceTexture = new SurfaceTexture(iGenerateTexture);
            this.surfaceTexture = surfaceTexture;
            setOnFrameAvailableListener(surfaceTexture, new C12484r(this), handler);
        } catch (RuntimeException e) {
            this.eglBase.release();
            handler.getLooper().quit();
            throw e;
        }
    }

    public static SurfaceTextureHelper create(String str, EglBase.Context context) {
        return create(str, context, false, new YuvConverter(), null);
    }

    public static SurfaceTextureHelper create(String str, EglBase.Context context, boolean z2) {
        return create(str, context, z2, new YuvConverter(), null);
    }

    public static SurfaceTextureHelper create(String str, EglBase.Context context, boolean z2, YuvConverter yuvConverter) {
        return create(str, context, z2, yuvConverter, null);
    }
}
