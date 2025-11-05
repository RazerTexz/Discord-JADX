package b.a.y.q0;

import com.discord.utilities.file.DownloadUtils;
import kotlin.Pair;
import rx.functions.Func2;

/* compiled from: StickerView.kt */
/* loaded from: classes2.dex */
public final class e<T1, T2, R> implements Func2<DownloadUtils.DownloadState, Integer, Pair<? extends DownloadUtils.DownloadState, ? extends Integer>> {
    public static final e j = new e();

    @Override // rx.functions.Func2
    public Pair<? extends DownloadUtils.DownloadState, ? extends Integer> call(DownloadUtils.DownloadState downloadState, Integer num) {
        return new Pair<>(downloadState, num);
    }
}
