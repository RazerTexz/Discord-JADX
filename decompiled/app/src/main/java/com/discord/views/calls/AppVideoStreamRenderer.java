package com.discord.views.calls;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.MainThread;
import co.discord.media_engine.VideoStreamRenderer;
import com.discord.stores.StoreStream;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import java.util.HashMap;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.webrtc.RendererCommon;
import p007b.p008a.p062y.p063j0.AppVideoStreamRenderer2;
import p007b.p008a.p062y.p063j0.AppVideoStreamRenderer3;
import p007b.p008a.p062y.p063j0.AppVideoStreamRenderer4;
import p007b.p008a.p062y.p063j0.AppVideoStreamRenderer5;
import p007b.p008a.p062y.p063j0.RxRendererEvents;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.TypeIntrinsics;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: AppVideoStreamRenderer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppVideoStreamRenderer extends VideoStreamRenderer {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public boolean isOverlay;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final BehaviorSubject<Unit> onSizeChangedSubject;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public Subscription updateRendererSizeSubscription;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public Integer streamId;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public BehaviorSubject<Point> currentFrameResolutionSubject;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public Function1<? super Point, Unit> onFrameRenderedListener;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public RendererCommon.ScalingType prevScalingType;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public RendererCommon.ScalingType prevScalingTypeMismatchOrientation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppVideoStreamRenderer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        this.onSizeChangedSubject = BehaviorSubject.m11130l0(Unit.f27425a);
        this.currentFrameResolutionSubject = BehaviorSubject.m11130l0(null);
        RendererCommon.ScalingType scalingType = RendererCommon.ScalingType.SCALE_ASPECT_BALANCED;
        this.prevScalingType = scalingType;
        this.prevScalingTypeMismatchOrientation = scalingType;
    }

    @MainThread
    /* JADX INFO: renamed from: b */
    public final void m8571b() {
        Subscription subscription = this.updateRendererSizeSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        HashMap<Integer, VideoStreamRenderer> map = AppVideoStreamRenderer5.f2029a;
        Integer num = this.streamId;
        Objects.requireNonNull(map, "null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        TypeIntrinsics.asMutableMap(map).remove(num);
        this.currentFrameResolutionSubject.onNext(null);
        map.isEmpty();
        VideoStreamRenderer.attachToStream$default(this, StoreStream.INSTANCE.getMediaEngine().getVoiceEngineNative(), null, null, 4, null);
    }

    @MainThread
    /* JADX INFO: renamed from: c */
    public final void m8572c(Integer newStreamId, RendererCommon.ScalingType scalingType, RendererCommon.ScalingType scalingTypeMismatchOrientation, boolean isVideoMirrored) {
        if (newStreamId == null) {
            m8571b();
            this.streamId = null;
            return;
        }
        boolean z2 = !Intrinsics3.areEqual(newStreamId, this.streamId);
        if (z2) {
            m8571b();
        }
        if (z2) {
            int iIntValue = newStreamId.intValue();
            HashMap<Integer, VideoStreamRenderer> map = AppVideoStreamRenderer5.f2029a;
            VideoStreamRenderer videoStreamRenderer = map.get(Integer.valueOf(iIntValue));
            if (videoStreamRenderer != null && videoStreamRenderer != this) {
                VideoStreamRenderer.attachToStream$default(videoStreamRenderer, StoreStream.INSTANCE.getMediaEngine().getVoiceEngineNative(), null, null, 4, null);
                map.remove(Integer.valueOf(iIntValue));
                map.isEmpty();
            }
            map.put(Integer.valueOf(iIntValue), this);
            RxRendererEvents rxRendererEvents = new RxRendererEvents();
            Subscription subscription = this.updateRendererSizeSubscription;
            if (subscription != null) {
                subscription.unsubscribe();
            }
            Observable<R> observableM11082A = this.onSizeChangedSubject.m11082A(new AppVideoStreamRenderer2(rxRendererEvents));
            Intrinsics3.checkNotNullExpressionValue(observableM11082A, "onSizeChangedSubject\n   …rameResolutionSampled() }");
            Observable observableM11083G = observableM11082A.m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
            Observable observableM8518ui = ObservableExtensionsKt.m8518ui(observableM11083G);
            AppVideoStreamRenderer3 appVideoStreamRenderer3 = new AppVideoStreamRenderer3(this);
            String simpleName = AppVideoStreamRenderer.class.getSimpleName();
            Intrinsics3.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
            ObservableExtensionsKt.appSubscribe$default(observableM8518ui, (Context) null, simpleName, new AppVideoStreamRenderer4(this), appVideoStreamRenderer3, (Function1) null, (Function0) null, (Function0) null, 113, (Object) null);
            StringBuilder sbM833U = outline.m833U("binding native renderer ");
            sbM833U.append(hashCode());
            sbM833U.append(" to stream id: ");
            sbM833U.append(iIntValue);
            Log.d("AppVideoStreamRenderer", sbM833U.toString());
            attachToStream(StoreStream.INSTANCE.getMediaEngine().getVoiceEngineNative(), String.valueOf(iIntValue), rxRendererEvents);
            this.streamId = newStreamId;
        }
        RendererCommon.ScalingType scalingType2 = scalingType != null ? scalingType : this.prevScalingType;
        RendererCommon.ScalingType scalingType3 = scalingTypeMismatchOrientation != null ? scalingTypeMismatchOrientation : this.prevScalingTypeMismatchOrientation;
        setMirror(isVideoMirrored);
        setZOrderMediaOverlay(this.isOverlay);
        if (scalingType2 == this.prevScalingType && scalingType3 == this.prevScalingTypeMismatchOrientation) {
            return;
        }
        setScalingType(scalingType2, scalingType3);
        this.prevScalingType = scalingType2;
        this.prevScalingTypeMismatchOrientation = scalingType3;
    }

    public final Function1<Point, Unit> getOnFrameRenderedListener() {
        return this.onFrameRenderedListener;
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.onSizeChangedSubject.onNext(Unit.f27425a);
        super.clearImage();
    }

    public final void setIsOverlay(boolean isOverlay) {
        this.isOverlay = isOverlay;
    }

    public final void setMatchVideoOrientation(boolean matchVideoOrientation) {
    }

    public final void setOnFrameRenderedListener(Function1<? super Point, Unit> function1) {
        this.onFrameRenderedListener = function1;
    }
}
