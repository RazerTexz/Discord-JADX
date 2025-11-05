package com.discord.overlay;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.view.View;
import b.a.n.f;
import com.discord.overlay.views.OverlayBubbleWrap;
import d0.j;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: OverlayService.kt */
/* loaded from: classes.dex */
public abstract class OverlayService extends Service {
    public static final Companion Companion = new Companion(null);
    public static final int NOTIFICATION_ID = 5858;
    public OverlayManager overlayManager;

    /* compiled from: OverlayService.kt */
    public static final class Companion {
        public Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: OverlayService.kt */
    public static final class a implements Runnable {
        public final /* synthetic */ OverlayBubbleWrap k;

        public a(OverlayBubbleWrap overlayBubbleWrap) {
            this.k = overlayBubbleWrap;
        }

        @Override // java.lang.Runnable
        public final void run() {
            OverlayService.this.getOverlayManager().b(this.k);
        }
    }

    /* compiled from: OverlayService.kt */
    public static final class b implements f {
        public b() {
        }

        @Override // b.a.n.f
        public void a(OverlayBubbleWrap overlayBubbleWrap) {
        }

        @Override // b.a.n.f
        public void b(OverlayBubbleWrap overlayBubbleWrap) {
            m.checkNotNullParameter(overlayBubbleWrap, "bubble");
            OverlayService.this.getOverlayManager().d(overlayBubbleWrap);
        }
    }

    /* compiled from: OverlayService.kt */
    public static final class c extends o implements Function1<View, Unit> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(View view) {
            m.checkNotNullParameter(view, "it");
            if (OverlayService.this.getOverlayManager().activeBubbles.isEmpty()) {
                throw new j(b.d.b.a.a.w("An operation is not implemented: ", "handle stop service"));
            }
            return Unit.a;
        }
    }

    private final boolean attachBubbleToWindow(Intent intent) {
        OverlayBubbleWrap overlayBubbleWrapCreateOverlayBubble = createOverlayBubble(intent);
        if (overlayBubbleWrapCreateOverlayBubble == null) {
            return false;
        }
        OverlayManager overlayManager = this.overlayManager;
        if (overlayManager == null) {
            m.throwUninitializedPropertyAccessException("overlayManager");
        }
        overlayManager.a(overlayBubbleWrapCreateOverlayBubble);
        overlayBubbleWrapCreateOverlayBubble.post(new a(overlayBubbleWrapCreateOverlayBubble));
        OverlayManager overlayManager2 = this.overlayManager;
        if (overlayManager2 == null) {
            m.throwUninitializedPropertyAccessException("overlayManager");
        }
        if (overlayManager2.trashWrap != null) {
            return true;
        }
        Context applicationContext = getApplicationContext();
        m.checkNotNullExpressionValue(applicationContext, "applicationContext");
        b.a.n.h.a aVar = new b.a.n.h.a(applicationContext);
        OverlayManager overlayManager3 = this.overlayManager;
        if (overlayManager3 == null) {
            m.throwUninitializedPropertyAccessException("overlayManager");
        }
        Objects.requireNonNull(overlayManager3);
        m.checkNotNullParameter(aVar, "trashWrap");
        overlayManager3.trashWrap = aVar;
        overlayManager3.windowManager.addView(aVar, aVar.getWindowLayoutParams());
        return true;
    }

    public abstract Notification createNotification(Intent intent);

    public abstract OverlayBubbleWrap createOverlayBubble(Intent intent);

    public final OverlayManager getOverlayManager() {
        OverlayManager overlayManager = this.overlayManager;
        if (overlayManager == null) {
            m.throwUninitializedPropertyAccessException("overlayManager");
        }
        return overlayManager;
    }

    public final void handleStart(Intent intent) {
        if (intent == null) {
            intent = new Intent();
        }
        if (attachBubbleToWindow(intent)) {
            startForeground(NOTIFICATION_ID, createNotification(intent));
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Context applicationContext = getApplicationContext();
        m.checkNotNullExpressionValue(applicationContext, "applicationContext");
        OverlayManager overlayManager = new OverlayManager(applicationContext, null, 2);
        this.overlayManager = overlayManager;
        overlayManager.trashEventListener = new b();
        if (overlayManager == null) {
            m.throwUninitializedPropertyAccessException("overlayManager");
        }
        c cVar = new c();
        Objects.requireNonNull(overlayManager);
        m.checkNotNullParameter(cVar, "<set-?>");
        overlayManager.onOverlayBubbleRemoved = cVar;
    }

    @Override // android.app.Service
    public void onDestroy() {
        OverlayManager overlayManager = this.overlayManager;
        if (overlayManager == null) {
            m.throwUninitializedPropertyAccessException("overlayManager");
        }
        overlayManager.close();
        super.onDestroy();
    }

    public final void setOverlayManager(OverlayManager overlayManager) {
        m.checkNotNullParameter(overlayManager, "<set-?>");
        this.overlayManager = overlayManager;
    }
}
