package org.webrtc;

import android.content.Context;
import android.media.MediaRecorder;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import org.webrtc.CameraSession;
import org.webrtc.CameraVideoCapturer;
import p007b.p100d.p104b.p105a.outline;
import p617h0.p628c.CameraVideoCapturer2;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CameraCapturer implements CameraVideoCapturer {
    private static final int MAX_OPEN_CAMERA_ATTEMPTS = 3;
    private static final int OPEN_CAMERA_DELAY_MS = 500;
    private static final int OPEN_CAMERA_TIMEOUT = 10000;
    private static final String TAG = "CameraCapturer";
    private Context applicationContext;
    private final CameraEnumerator cameraEnumerator;
    private String cameraName;

    @Nullable
    private CameraVideoCapturer.CameraStatistics cameraStatistics;
    private Handler cameraThreadHandler;
    private CapturerObserver capturerObserver;

    @Nullable
    private CameraSession currentSession;
    private final CameraVideoCapturer.CameraEventsHandler eventsHandler;
    private boolean firstFrameObserved;
    private int framerate;
    private int height;
    private int openAttemptsRemaining;
    private String pendingCameraName;
    private boolean sessionOpening;
    private SurfaceTextureHelper surfaceHelper;

    @Nullable
    private CameraVideoCapturer.CameraSwitchHandler switchEventsHandler;
    private final Handler uiThreadHandler;
    private int width;

    @Nullable
    private final CameraSession.CreateSessionCallback createSessionCallback = new C129481();

    @Nullable
    private final CameraSession.Events cameraSessionEventsHandler = new C129492();
    private final Runnable openCameraTimeoutRunnable = new RunnableC129503();
    private final Object stateLock = new Object();
    private SwitchState switchState = SwitchState.IDLE;

    /* JADX INFO: renamed from: org.webrtc.CameraCapturer$1 */
    public class C129481 implements CameraSession.CreateSessionCallback {
        public C129481() {
        }

        @Override // org.webrtc.CameraSession.CreateSessionCallback
        public void onDone(CameraSession cameraSession) {
            CameraCapturer.access$000(CameraCapturer.this);
            Logging.m11027d(CameraCapturer.TAG, "Create session done. Switch state: " + CameraCapturer.access$100(CameraCapturer.this));
            CameraCapturer.access$300(CameraCapturer.this).removeCallbacks(CameraCapturer.access$200(CameraCapturer.this));
            synchronized (CameraCapturer.access$400(CameraCapturer.this)) {
                CameraCapturer.access$500(CameraCapturer.this).onCapturerStarted(true);
                CameraCapturer.access$602(CameraCapturer.this, false);
                CameraCapturer.access$702(CameraCapturer.this, cameraSession);
                CameraCapturer cameraCapturer = CameraCapturer.this;
                CameraCapturer.access$802(cameraCapturer, new CameraVideoCapturer.CameraStatistics(CameraCapturer.access$900(cameraCapturer), CameraCapturer.access$1000(CameraCapturer.this)));
                CameraCapturer.access$1102(CameraCapturer.this, false);
                CameraCapturer.access$400(CameraCapturer.this).notifyAll();
                if (CameraCapturer.access$100(CameraCapturer.this) == SwitchState.IN_PROGRESS) {
                    CameraCapturer.access$102(CameraCapturer.this, SwitchState.IDLE);
                    if (CameraCapturer.access$1200(CameraCapturer.this) != null) {
                        CameraCapturer.access$1200(CameraCapturer.this).onCameraSwitchDone(CameraCapturer.access$1400(CameraCapturer.this).isFrontFacing(CameraCapturer.access$1300(CameraCapturer.this)));
                        CameraCapturer.access$1202(CameraCapturer.this, null);
                    }
                } else if (CameraCapturer.access$100(CameraCapturer.this) == SwitchState.PENDING) {
                    String strAccess$1500 = CameraCapturer.access$1500(CameraCapturer.this);
                    CameraCapturer.access$1502(CameraCapturer.this, null);
                    CameraCapturer.access$102(CameraCapturer.this, SwitchState.IDLE);
                    CameraCapturer cameraCapturer2 = CameraCapturer.this;
                    CameraCapturer.access$1600(cameraCapturer2, CameraCapturer.access$1200(cameraCapturer2), strAccess$1500);
                }
            }
        }

        @Override // org.webrtc.CameraSession.CreateSessionCallback
        public void onFailure(CameraSession.FailureType failureType, String str) {
            CameraCapturer.access$000(CameraCapturer.this);
            CameraCapturer.access$300(CameraCapturer.this).removeCallbacks(CameraCapturer.access$200(CameraCapturer.this));
            synchronized (CameraCapturer.access$400(CameraCapturer.this)) {
                CameraCapturer.access$500(CameraCapturer.this).onCapturerStarted(false);
                CameraCapturer.access$1710(CameraCapturer.this);
                if (CameraCapturer.access$1700(CameraCapturer.this) <= 0) {
                    Logging.m11031w(CameraCapturer.TAG, "Opening camera failed, passing: " + str);
                    CameraCapturer.access$602(CameraCapturer.this, false);
                    CameraCapturer.access$400(CameraCapturer.this).notifyAll();
                    SwitchState switchStateAccess$100 = CameraCapturer.access$100(CameraCapturer.this);
                    SwitchState switchState = SwitchState.IDLE;
                    if (switchStateAccess$100 != switchState) {
                        if (CameraCapturer.access$1200(CameraCapturer.this) != null) {
                            CameraCapturer.access$1200(CameraCapturer.this).onCameraSwitchError(str);
                            CameraCapturer.access$1202(CameraCapturer.this, null);
                        }
                        CameraCapturer.access$102(CameraCapturer.this, switchState);
                    }
                    if (failureType == CameraSession.FailureType.DISCONNECTED) {
                        CameraCapturer.access$1000(CameraCapturer.this).onCameraDisconnected();
                    } else {
                        CameraCapturer.access$1000(CameraCapturer.this).onCameraError(str);
                    }
                } else {
                    Logging.m11031w(CameraCapturer.TAG, "Opening camera failed, retry: " + str);
                    CameraCapturer.access$1800(CameraCapturer.this, CameraCapturer.OPEN_CAMERA_DELAY_MS);
                }
            }
        }
    }

    /* JADX INFO: renamed from: org.webrtc.CameraCapturer$2 */
    public class C129492 implements CameraSession.Events {
        public C129492() {
        }

        @Override // org.webrtc.CameraSession.Events
        public void onCameraClosed(CameraSession cameraSession) {
            CameraCapturer.access$000(CameraCapturer.this);
            synchronized (CameraCapturer.access$400(CameraCapturer.this)) {
                if (cameraSession == CameraCapturer.access$700(CameraCapturer.this) || CameraCapturer.access$700(CameraCapturer.this) == null) {
                    CameraCapturer.access$1000(CameraCapturer.this).onCameraClosed();
                } else {
                    Logging.m11027d(CameraCapturer.TAG, "onCameraClosed from another session.");
                }
            }
        }

        @Override // org.webrtc.CameraSession.Events
        public void onCameraDisconnected(CameraSession cameraSession) {
            CameraCapturer.access$000(CameraCapturer.this);
            synchronized (CameraCapturer.access$400(CameraCapturer.this)) {
                if (cameraSession != CameraCapturer.access$700(CameraCapturer.this)) {
                    Logging.m11031w(CameraCapturer.TAG, "onCameraDisconnected from another session.");
                } else {
                    CameraCapturer.access$1000(CameraCapturer.this).onCameraDisconnected();
                    CameraCapturer.this.stopCapture();
                }
            }
        }

        @Override // org.webrtc.CameraSession.Events
        public void onCameraError(CameraSession cameraSession, String str) {
            CameraCapturer.access$000(CameraCapturer.this);
            synchronized (CameraCapturer.access$400(CameraCapturer.this)) {
                if (cameraSession == CameraCapturer.access$700(CameraCapturer.this)) {
                    CameraCapturer.access$1000(CameraCapturer.this).onCameraError(str);
                    CameraCapturer.this.stopCapture();
                } else {
                    Logging.m11031w(CameraCapturer.TAG, "onCameraError from another session: " + str);
                }
            }
        }

        @Override // org.webrtc.CameraSession.Events
        public void onCameraOpening() {
            CameraCapturer.access$000(CameraCapturer.this);
            synchronized (CameraCapturer.access$400(CameraCapturer.this)) {
                if (CameraCapturer.access$700(CameraCapturer.this) != null) {
                    Logging.m11031w(CameraCapturer.TAG, "onCameraOpening while session was open.");
                } else {
                    CameraCapturer.access$1000(CameraCapturer.this).onCameraOpening(CameraCapturer.access$1300(CameraCapturer.this));
                }
            }
        }

        @Override // org.webrtc.CameraSession.Events
        public void onFrameCaptured(CameraSession cameraSession, VideoFrame videoFrame) {
            CameraCapturer.access$000(CameraCapturer.this);
            synchronized (CameraCapturer.access$400(CameraCapturer.this)) {
                if (cameraSession != CameraCapturer.access$700(CameraCapturer.this)) {
                    Logging.m11031w(CameraCapturer.TAG, "onFrameCaptured from another session.");
                    return;
                }
                if (!CameraCapturer.access$1100(CameraCapturer.this)) {
                    CameraCapturer.access$1000(CameraCapturer.this).onFirstFrameAvailable();
                    CameraCapturer.access$1102(CameraCapturer.this, true);
                }
                CameraCapturer.access$800(CameraCapturer.this).addFrame();
                CameraCapturer.access$500(CameraCapturer.this).onFrameCaptured(videoFrame);
            }
        }
    }

    /* JADX INFO: renamed from: org.webrtc.CameraCapturer$3 */
    public class RunnableC129503 implements Runnable {
        public RunnableC129503() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraCapturer.access$1000(CameraCapturer.this).onCameraError("Camera failed to start within timeout.");
        }
    }

    /* JADX INFO: renamed from: org.webrtc.CameraCapturer$4 */
    public class C129514 implements CameraVideoCapturer.CameraEventsHandler {
        public C129514() {
        }

        @Override // org.webrtc.CameraVideoCapturer.CameraEventsHandler
        public void onCameraClosed() {
        }

        @Override // org.webrtc.CameraVideoCapturer.CameraEventsHandler
        public void onCameraDisconnected() {
        }

        @Override // org.webrtc.CameraVideoCapturer.CameraEventsHandler
        public void onCameraError(String str) {
        }

        @Override // org.webrtc.CameraVideoCapturer.CameraEventsHandler
        public void onCameraFreezed(String str) {
        }

        @Override // org.webrtc.CameraVideoCapturer.CameraEventsHandler
        public void onCameraOpening(String str) {
        }

        @Override // org.webrtc.CameraVideoCapturer.CameraEventsHandler
        public void onFirstFrameAvailable() {
        }
    }

    /* JADX INFO: renamed from: org.webrtc.CameraCapturer$5 */
    public class RunnableC129525 implements Runnable {
        public RunnableC129525() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraCapturer cameraCapturer = CameraCapturer.this;
            cameraCapturer.createCameraSession(CameraCapturer.access$1900(cameraCapturer), CameraCapturer.access$2000(CameraCapturer.this), CameraCapturer.access$2100(CameraCapturer.this), CameraCapturer.access$900(CameraCapturer.this), CameraCapturer.access$1300(CameraCapturer.this), CameraCapturer.access$2200(CameraCapturer.this), CameraCapturer.access$2300(CameraCapturer.this), CameraCapturer.access$2400(CameraCapturer.this));
        }
    }

    /* JADX INFO: renamed from: org.webrtc.CameraCapturer$6 */
    public class RunnableC129536 implements Runnable {
        public final /* synthetic */ CameraSession val$oldSession;

        public RunnableC129536(CameraSession cameraSession) {
            this.val$oldSession = cameraSession;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$oldSession.stop();
        }
    }

    /* JADX INFO: renamed from: org.webrtc.CameraCapturer$7 */
    public class RunnableC129547 implements Runnable {
        public final /* synthetic */ CameraVideoCapturer.CameraSwitchHandler val$switchEventsHandler;

        public RunnableC129547(CameraVideoCapturer.CameraSwitchHandler cameraSwitchHandler) {
            this.val$switchEventsHandler = cameraSwitchHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            List listAsList = Arrays.asList(CameraCapturer.access$1400(CameraCapturer.this).getDeviceNames());
            if (listAsList.size() < 2) {
                CameraCapturer.access$2500(CameraCapturer.this, "No camera to switch to.", this.val$switchEventsHandler);
            } else {
                CameraCapturer.access$1600(CameraCapturer.this, this.val$switchEventsHandler, (String) listAsList.get((listAsList.indexOf(CameraCapturer.access$1300(CameraCapturer.this)) + 1) % listAsList.size()));
            }
        }
    }

    /* JADX INFO: renamed from: org.webrtc.CameraCapturer$8 */
    public class RunnableC129558 implements Runnable {
        public final /* synthetic */ String val$cameraName;
        public final /* synthetic */ CameraVideoCapturer.CameraSwitchHandler val$switchEventsHandler;

        public RunnableC129558(CameraVideoCapturer.CameraSwitchHandler cameraSwitchHandler, String str) {
            this.val$switchEventsHandler = cameraSwitchHandler;
            this.val$cameraName = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraCapturer.access$1600(CameraCapturer.this, this.val$switchEventsHandler, this.val$cameraName);
        }
    }

    /* JADX INFO: renamed from: org.webrtc.CameraCapturer$9 */
    public class RunnableC129569 implements Runnable {
        public final /* synthetic */ CameraSession val$oldSession;

        public RunnableC129569(CameraSession cameraSession) {
            this.val$oldSession = cameraSession;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$oldSession.stop();
        }
    }

    public enum SwitchState {
        IDLE,
        PENDING,
        IN_PROGRESS
    }

    public CameraCapturer(String str, @Nullable CameraVideoCapturer.CameraEventsHandler cameraEventsHandler, CameraEnumerator cameraEnumerator) {
        this.eventsHandler = cameraEventsHandler == null ? new C129514() : cameraEventsHandler;
        this.cameraEnumerator = cameraEnumerator;
        this.cameraName = str;
        List listAsList = Arrays.asList(cameraEnumerator.getDeviceNames());
        this.uiThreadHandler = new Handler(Looper.getMainLooper());
        if (listAsList.isEmpty()) {
            throw new RuntimeException("No cameras attached.");
        }
        if (!listAsList.contains(this.cameraName)) {
            throw new IllegalArgumentException(outline.m822J(outline.m833U("Camera name "), this.cameraName, " does not match any known camera device."));
        }
    }

    public static /* synthetic */ void access$000(CameraCapturer cameraCapturer) {
        cameraCapturer.checkIsOnCameraThread();
    }

    public static /* synthetic */ SwitchState access$100(CameraCapturer cameraCapturer) {
        return cameraCapturer.switchState;
    }

    public static /* synthetic */ CameraVideoCapturer.CameraEventsHandler access$1000(CameraCapturer cameraCapturer) {
        return cameraCapturer.eventsHandler;
    }

    public static /* synthetic */ SwitchState access$102(CameraCapturer cameraCapturer, SwitchState switchState) {
        cameraCapturer.switchState = switchState;
        return switchState;
    }

    public static /* synthetic */ boolean access$1100(CameraCapturer cameraCapturer) {
        return cameraCapturer.firstFrameObserved;
    }

    public static /* synthetic */ boolean access$1102(CameraCapturer cameraCapturer, boolean z2) {
        cameraCapturer.firstFrameObserved = z2;
        return z2;
    }

    public static /* synthetic */ CameraVideoCapturer.CameraSwitchHandler access$1200(CameraCapturer cameraCapturer) {
        return cameraCapturer.switchEventsHandler;
    }

    public static /* synthetic */ CameraVideoCapturer.CameraSwitchHandler access$1202(CameraCapturer cameraCapturer, CameraVideoCapturer.CameraSwitchHandler cameraSwitchHandler) {
        cameraCapturer.switchEventsHandler = cameraSwitchHandler;
        return cameraSwitchHandler;
    }

    public static /* synthetic */ String access$1300(CameraCapturer cameraCapturer) {
        return cameraCapturer.cameraName;
    }

    public static /* synthetic */ CameraEnumerator access$1400(CameraCapturer cameraCapturer) {
        return cameraCapturer.cameraEnumerator;
    }

    public static /* synthetic */ String access$1500(CameraCapturer cameraCapturer) {
        return cameraCapturer.pendingCameraName;
    }

    public static /* synthetic */ String access$1502(CameraCapturer cameraCapturer, String str) {
        cameraCapturer.pendingCameraName = str;
        return str;
    }

    public static /* synthetic */ void access$1600(CameraCapturer cameraCapturer, CameraVideoCapturer.CameraSwitchHandler cameraSwitchHandler, String str) {
        cameraCapturer.switchCameraInternal(cameraSwitchHandler, str);
    }

    public static /* synthetic */ int access$1700(CameraCapturer cameraCapturer) {
        return cameraCapturer.openAttemptsRemaining;
    }

    public static /* synthetic */ int access$1710(CameraCapturer cameraCapturer) {
        int i = cameraCapturer.openAttemptsRemaining;
        cameraCapturer.openAttemptsRemaining = i - 1;
        return i;
    }

    public static /* synthetic */ void access$1800(CameraCapturer cameraCapturer, int i) {
        cameraCapturer.createSessionInternal(i);
    }

    public static /* synthetic */ CameraSession.CreateSessionCallback access$1900(CameraCapturer cameraCapturer) {
        return cameraCapturer.createSessionCallback;
    }

    public static /* synthetic */ Runnable access$200(CameraCapturer cameraCapturer) {
        return cameraCapturer.openCameraTimeoutRunnable;
    }

    public static /* synthetic */ CameraSession.Events access$2000(CameraCapturer cameraCapturer) {
        return cameraCapturer.cameraSessionEventsHandler;
    }

    public static /* synthetic */ Context access$2100(CameraCapturer cameraCapturer) {
        return cameraCapturer.applicationContext;
    }

    public static /* synthetic */ int access$2200(CameraCapturer cameraCapturer) {
        return cameraCapturer.width;
    }

    public static /* synthetic */ int access$2300(CameraCapturer cameraCapturer) {
        return cameraCapturer.height;
    }

    public static /* synthetic */ int access$2400(CameraCapturer cameraCapturer) {
        return cameraCapturer.framerate;
    }

    public static /* synthetic */ void access$2500(CameraCapturer cameraCapturer, String str, CameraVideoCapturer.CameraSwitchHandler cameraSwitchHandler) {
        cameraCapturer.reportCameraSwitchError(str, cameraSwitchHandler);
    }

    public static /* synthetic */ Handler access$300(CameraCapturer cameraCapturer) {
        return cameraCapturer.uiThreadHandler;
    }

    public static /* synthetic */ Object access$400(CameraCapturer cameraCapturer) {
        return cameraCapturer.stateLock;
    }

    public static /* synthetic */ CapturerObserver access$500(CameraCapturer cameraCapturer) {
        return cameraCapturer.capturerObserver;
    }

    public static /* synthetic */ boolean access$602(CameraCapturer cameraCapturer, boolean z2) {
        cameraCapturer.sessionOpening = z2;
        return z2;
    }

    public static /* synthetic */ CameraSession access$700(CameraCapturer cameraCapturer) {
        return cameraCapturer.currentSession;
    }

    public static /* synthetic */ CameraSession access$702(CameraCapturer cameraCapturer, CameraSession cameraSession) {
        cameraCapturer.currentSession = cameraSession;
        return cameraSession;
    }

    public static /* synthetic */ CameraVideoCapturer.CameraStatistics access$800(CameraCapturer cameraCapturer) {
        return cameraCapturer.cameraStatistics;
    }

    public static /* synthetic */ CameraVideoCapturer.CameraStatistics access$802(CameraCapturer cameraCapturer, CameraVideoCapturer.CameraStatistics cameraStatistics) {
        cameraCapturer.cameraStatistics = cameraStatistics;
        return cameraStatistics;
    }

    public static /* synthetic */ SurfaceTextureHelper access$900(CameraCapturer cameraCapturer) {
        return cameraCapturer.surfaceHelper;
    }

    private void checkIsOnCameraThread() {
        if (Thread.currentThread() == this.cameraThreadHandler.getLooper().getThread()) {
            return;
        }
        Logging.m11028e(TAG, "Check is on camera thread failed.");
        throw new RuntimeException("Not on camera thread.");
    }

    private void createSessionInternal(int i) {
        this.uiThreadHandler.postDelayed(this.openCameraTimeoutRunnable, i + OPEN_CAMERA_TIMEOUT);
        this.cameraThreadHandler.postDelayed(new RunnableC129525(), i);
    }

    private void reportCameraSwitchError(String str, @Nullable CameraVideoCapturer.CameraSwitchHandler cameraSwitchHandler) {
        Logging.m11028e(TAG, str);
        if (cameraSwitchHandler != null) {
            cameraSwitchHandler.onCameraSwitchError(str);
        }
    }

    private void switchCameraInternal(@Nullable CameraVideoCapturer.CameraSwitchHandler cameraSwitchHandler, String str) {
        Logging.m11027d(TAG, "switchCamera internal");
        if (!Arrays.asList(this.cameraEnumerator.getDeviceNames()).contains(str)) {
            reportCameraSwitchError(outline.m883w("Attempted to switch to unknown camera device ", str), cameraSwitchHandler);
            return;
        }
        synchronized (this.stateLock) {
            if (this.switchState != SwitchState.IDLE) {
                reportCameraSwitchError("Camera switch already in progress.", cameraSwitchHandler);
                return;
            }
            boolean z2 = this.sessionOpening;
            if (!z2 && this.currentSession == null) {
                reportCameraSwitchError("switchCamera: camera is not running.", cameraSwitchHandler);
                return;
            }
            this.switchEventsHandler = cameraSwitchHandler;
            if (z2) {
                this.switchState = SwitchState.PENDING;
                this.pendingCameraName = str;
                return;
            }
            this.switchState = SwitchState.IN_PROGRESS;
            Logging.m11027d(TAG, "switchCamera: Stopping session");
            this.cameraStatistics.release();
            this.cameraStatistics = null;
            this.cameraThreadHandler.post(new RunnableC129569(this.currentSession));
            this.currentSession = null;
            this.cameraName = str;
            this.sessionOpening = true;
            this.openAttemptsRemaining = 1;
            createSessionInternal(0);
            Logging.m11027d(TAG, "switchCamera done");
        }
    }

    @Override // org.webrtc.CameraVideoCapturer
    public /* synthetic */ void addMediaRecorderToCamera(MediaRecorder mediaRecorder, CameraVideoCapturer.MediaRecorderHandler mediaRecorderHandler) {
        CameraVideoCapturer2.m10660a(this, mediaRecorder, mediaRecorderHandler);
    }

    @Override // org.webrtc.VideoCapturer
    public void changeCaptureFormat(int i, int i2, int i3) {
        StringBuilder sbM835W = outline.m835W("changeCaptureFormat: ", i, "x", i2, "@");
        sbM835W.append(i3);
        Logging.m11027d(TAG, sbM835W.toString());
        synchronized (this.stateLock) {
            stopCapture();
            startCapture(i, i2, i3);
        }
    }

    public abstract void createCameraSession(CameraSession.CreateSessionCallback createSessionCallback, CameraSession.Events events, Context context, SurfaceTextureHelper surfaceTextureHelper, String str, int i, int i2, int i3);

    @Override // org.webrtc.VideoCapturer
    public void dispose() {
        Logging.m11027d(TAG, "dispose");
        stopCapture();
    }

    public String getCameraName() {
        String str;
        synchronized (this.stateLock) {
            str = this.cameraName;
        }
        return str;
    }

    @Override // org.webrtc.VideoCapturer
    public void initialize(SurfaceTextureHelper surfaceTextureHelper, Context context, CapturerObserver capturerObserver) {
        this.applicationContext = context;
        this.capturerObserver = capturerObserver;
        this.surfaceHelper = surfaceTextureHelper;
        this.cameraThreadHandler = surfaceTextureHelper.getHandler();
    }

    @Override // org.webrtc.VideoCapturer
    public boolean isScreencast() {
        return false;
    }

    public void printStackTrace() {
        Handler handler = this.cameraThreadHandler;
        Thread thread = handler != null ? handler.getLooper().getThread() : null;
        if (thread != null) {
            StackTraceElement[] stackTrace = thread.getStackTrace();
            if (stackTrace.length > 0) {
                Logging.m11027d(TAG, "CameraCapturer stack trace:");
                for (StackTraceElement stackTraceElement : stackTrace) {
                    Logging.m11027d(TAG, stackTraceElement.toString());
                }
            }
        }
    }

    @Override // org.webrtc.CameraVideoCapturer
    public /* synthetic */ void removeMediaRecorderFromCamera(CameraVideoCapturer.MediaRecorderHandler mediaRecorderHandler) {
        CameraVideoCapturer2.m10661b(this, mediaRecorderHandler);
    }

    @Override // org.webrtc.VideoCapturer
    public void startCapture(int i, int i2, int i3) {
        StringBuilder sbM835W = outline.m835W("startCapture: ", i, "x", i2, "@");
        sbM835W.append(i3);
        Logging.m11027d(TAG, sbM835W.toString());
        if (this.applicationContext == null) {
            throw new RuntimeException("CameraCapturer must be initialized before calling startCapture.");
        }
        synchronized (this.stateLock) {
            if (!this.sessionOpening && this.currentSession == null) {
                this.width = i;
                this.height = i2;
                this.framerate = i3;
                this.sessionOpening = true;
                this.openAttemptsRemaining = 3;
                createSessionInternal(0);
                return;
            }
            Logging.m11031w(TAG, "Session already open");
        }
    }

    @Override // org.webrtc.VideoCapturer
    public void stopCapture() {
        Logging.m11027d(TAG, "Stop capture");
        synchronized (this.stateLock) {
            while (this.sessionOpening) {
                Logging.m11027d(TAG, "Stop capture: Waiting for session to open");
                try {
                    this.stateLock.wait();
                } catch (InterruptedException unused) {
                    Logging.m11031w(TAG, "Stop capture interrupted while waiting for the session to open.");
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            if (this.currentSession != null) {
                Logging.m11027d(TAG, "Stop capture: Nulling session");
                this.cameraStatistics.release();
                this.cameraStatistics = null;
                this.cameraThreadHandler.post(new RunnableC129536(this.currentSession));
                this.currentSession = null;
                this.capturerObserver.onCapturerStopped();
            } else {
                Logging.m11027d(TAG, "Stop capture: No session open");
            }
        }
        Logging.m11027d(TAG, "Stop capture done");
    }

    @Override // org.webrtc.CameraVideoCapturer
    public void switchCamera(CameraVideoCapturer.CameraSwitchHandler cameraSwitchHandler) {
        Logging.m11027d(TAG, "switchCamera");
        this.cameraThreadHandler.post(new RunnableC129547(cameraSwitchHandler));
    }

    @Override // org.webrtc.CameraVideoCapturer
    public void switchCamera(CameraVideoCapturer.CameraSwitchHandler cameraSwitchHandler, String str) {
        Logging.m11027d(TAG, "switchCamera");
        this.cameraThreadHandler.post(new RunnableC129558(cameraSwitchHandler, str));
    }
}
