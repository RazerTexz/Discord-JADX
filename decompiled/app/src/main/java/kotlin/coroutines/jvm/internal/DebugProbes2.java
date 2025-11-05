package kotlin.coroutines.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;
import org.jetbrains.annotations.NotNull;

/* compiled from: DebugProbes.kt */
/* renamed from: kotlin.coroutines.jvm.internal.DebugProbesKt, reason: use source file name */
/* loaded from: discord-126021.apk:DebugProbesKt.bin */
public final class DebugProbes2 {
    @NotNull
    public static final <T> Continuation<T> probeCoroutineCreated(@NotNull Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return DebugProbesImpl.INSTANCE.probeCoroutineCreated$kotlinx_coroutines_core(continuation);
    }

    public static final void probeCoroutineResumed(@NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "frame");
        DebugProbesImpl.INSTANCE.probeCoroutineResumed$kotlinx_coroutines_core(continuation);
    }

    public static final void probeCoroutineSuspended(@NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "frame");
        DebugProbesImpl.INSTANCE.probeCoroutineSuspended$kotlinx_coroutines_core(continuation);
    }
}
