package p007b.p076b.p077a.p079d;

import java.io.File;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import p507d0.p578f0.C12075n;
import p507d0.p580t._Arrays;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: b.b.a.d.g, reason: use source file name */
/* JADX INFO: compiled from: FileListAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FileListAdapter2 extends Lambda implements Function1<File, Sequence<? extends File>> {

    /* JADX INFO: renamed from: j */
    public static final FileListAdapter2 f2143j = new FileListAdapter2();

    public FileListAdapter2() {
        super(1);
    }

    /* JADX INFO: renamed from: a */
    public final Sequence<File> m398a(File file) {
        Sequence<File> sequenceAsSequence;
        Intrinsics3.checkNotNullParameter(file, "$this$getFileList");
        File[] fileArrListFiles = file.listFiles();
        return (fileArrListFiles == null || (sequenceAsSequence = _Arrays.asSequence(fileArrListFiles)) == null) ? C12075n.emptySequence() : sequenceAsSequence;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Sequence<? extends File> invoke(File file) {
        return m398a(file);
    }
}
