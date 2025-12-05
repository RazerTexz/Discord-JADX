package com.discord.overlay;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.view.View;
import com.discord.overlay.views.OverlayBubbleWrap;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p036n.TrashEventListener;
import p007b.p008a.p036n.p038h.OverlayTrashWrap;
import p007b.p100d.p104b.p105a.outline;
import p507d0.Standard2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

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
    /* renamed from: com.discord.overlay.OverlayService$a */
    public static final class RunnableC5567a implements Runnable {

        /* renamed from: k */
        public final /* synthetic */ OverlayBubbleWrap f18616k;

        public RunnableC5567a(OverlayBubbleWrap overlayBubbleWrap) {
            this.f18616k = overlayBubbleWrap;
        }

        @Override // java.lang.Runnable
        public final void run() {
            OverlayService.this.getOverlayManager().m8431b(this.f18616k);
        }
    }

    /* compiled from: OverlayService.kt */
    /* renamed from: com.discord.overlay.OverlayService$b */
    public static final class C5568b implements TrashEventListener {
        public C5568b() {
        }

        @Override // p007b.p008a.p036n.TrashEventListener
        /* renamed from: a */
        public void mo227a(OverlayBubbleWrap overlayBubbleWrap) {
        }

        @Override // p007b.p008a.p036n.TrashEventListener
        /* renamed from: b */
        public void mo228b(OverlayBubbleWrap overlayBubbleWrap) {
            Intrinsics3.checkNotNullParameter(overlayBubbleWrap, "bubble");
            OverlayService.this.getOverlayManager().m8433d(overlayBubbleWrap);
        }
    }

    /* compiled from: OverlayService.kt */
    /* renamed from: com.discord.overlay.OverlayService$c */
    public static final class C5569c extends Lambda implements Function1<View, Unit> {
        public C5569c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            if (OverlayService.this.getOverlayManager().activeBubbles.isEmpty()) {
                throw new Standard2(outline.m883w("An operation is not implemented: ", "handle stop service"));
            }
            return Unit.f27425a;
        }
    }

    private final boolean attachBubbleToWindow(Intent intent) {
        OverlayBubbleWrap overlayBubbleWrapCreateOverlayBubble = createOverlayBubble(intent);
        if (overlayBubbleWrapCreateOverlayBubble == null) {
            return false;
        }
        OverlayManager overlayManager = this.overlayManager;
        if (overlayManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("overlayManager");
        }
        overlayManager.m8430a(overlayBubbleWrapCreateOverlayBubble);
        overlayBubbleWrapCreateOverlayBubble.post(new RunnableC5567a(overlayBubbleWrapCreateOverlayBubble));
        OverlayManager overlayManager2 = this.overlayManager;
        if (overlayManager2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("overlayManager");
        }
        if (overlayManager2.trashWrap != null) {
            return true;
        }
        Context applicationContext = getApplicationContext();
        Intrinsics3.checkNotNullExpressionValue(applicationContext, "applicationContext");
        OverlayTrashWrap overlayTrashWrap = new OverlayTrashWrap(applicationContext);
        OverlayManager overlayManager3 = this.overlayManager;
        if (overlayManager3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("overlayManager");
        }
        Objects.requireNonNull(overlayManager3);
        Intrinsics3.checkNotNullParameter(overlayTrashWrap, "trashWrap");
        overlayManager3.trashWrap = overlayTrashWrap;
        overlayManager3.windowManager.addView(overlayTrashWrap, overlayTrashWrap.getWindowLayoutParams());
        return true;
    }

    public abstract Notification createNotification(Intent intent);

    public abstract OverlayBubbleWrap createOverlayBubble(Intent intent);

    public final OverlayManager getOverlayManager() {
        OverlayManager overlayManager = this.overlayManager;
        if (overlayManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("overlayManager");
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
        Intrinsics3.checkNotNullExpressionValue(applicationContext, "applicationContext");
        OverlayManager overlayManager = new OverlayManager(applicationContext, null, 2);
        this.overlayManager = overlayManager;
        overlayManager.trashEventListener = new C5568b();
        if (overlayManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("overlayManager");
        }
        C5569c c5569c = new C5569c();
        Objects.requireNonNull(overlayManager);
        Intrinsics3.checkNotNullParameter(c5569c, "<set-?>");
        overlayManager.onOverlayBubbleRemoved = c5569c;
    }

    @Override // android.app.Service
    public void onDestroy() {
        OverlayManager overlayManager = this.overlayManager;
        if (overlayManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("overlayManager");
        }
        overlayManager.close();
        super.onDestroy();
    }

    public final void setOverlayManager(OverlayManager overlayManager) {
        Intrinsics3.checkNotNullParameter(overlayManager, "<set-?>");
        this.overlayManager = overlayManager;
    }
}
