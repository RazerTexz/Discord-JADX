package p507d0.p591y;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import p507d0.p580t.AbstractIterator3;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.y.d, reason: use source file name */
/* JADX INFO: compiled from: FileTreeWalk.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FileTreeWalk implements Sequence<File> {

    /* JADX INFO: renamed from: a */
    public final File f25253a;

    /* JADX INFO: renamed from: b */
    public final FileTreeWalk2 f25254b;

    /* JADX INFO: renamed from: c */
    public final Function1<File, Boolean> f25255c;

    /* JADX INFO: renamed from: d */
    public final Function1<File, Unit> f25256d;

    /* JADX INFO: renamed from: e */
    public final Function2<File, IOException, Unit> f25257e;

    /* JADX INFO: renamed from: f */
    public final int f25258f;

    /* JADX INFO: renamed from: d0.y.d$a */
    /* JADX INFO: compiled from: FileTreeWalk.kt */
    public static abstract class a extends c {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(File file) {
            super(file);
            Intrinsics3.checkNotNullParameter(file, "rootDir");
        }
    }

    /* JADX INFO: renamed from: d0.y.d$b */
    /* JADX INFO: compiled from: FileTreeWalk.kt */
    public final class b extends AbstractIterator3<File> {

        /* JADX INFO: renamed from: l */
        public final ArrayDeque<c> f25259l;

        /* JADX INFO: renamed from: d0.y.d$b$a */
        /* JADX INFO: compiled from: FileTreeWalk.kt */
        public final class a extends a {

            /* JADX INFO: renamed from: b */
            public boolean f25261b;

            /* JADX INFO: renamed from: c */
            public File[] f25262c;

            /* JADX INFO: renamed from: d */
            public int f25263d;

            /* JADX INFO: renamed from: e */
            public boolean f25264e;

            /* JADX INFO: renamed from: f */
            public final /* synthetic */ b f25265f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b bVar, File file) {
                super(file);
                Intrinsics3.checkNotNullParameter(file, "rootDir");
                this.f25265f = bVar;
            }

            @Override // p507d0.p591y.FileTreeWalk.c
            public File step() {
                if (!this.f25264e && this.f25262c == null) {
                    Function1 function1Access$getOnEnter$p = FileTreeWalk.access$getOnEnter$p(FileTreeWalk.this);
                    if (function1Access$getOnEnter$p != null && !((Boolean) function1Access$getOnEnter$p.invoke(getRoot())).booleanValue()) {
                        return null;
                    }
                    File[] fileArrListFiles = getRoot().listFiles();
                    this.f25262c = fileArrListFiles;
                    if (fileArrListFiles == null) {
                        Function2 function2Access$getOnFail$p = FileTreeWalk.access$getOnFail$p(FileTreeWalk.this);
                        if (function2Access$getOnFail$p != null) {
                        }
                        this.f25264e = true;
                    }
                }
                File[] fileArr = this.f25262c;
                if (fileArr != null) {
                    int i = this.f25263d;
                    Intrinsics3.checkNotNull(fileArr);
                    if (i < fileArr.length) {
                        File[] fileArr2 = this.f25262c;
                        Intrinsics3.checkNotNull(fileArr2);
                        int i2 = this.f25263d;
                        this.f25263d = i2 + 1;
                        return fileArr2[i2];
                    }
                }
                if (!this.f25261b) {
                    this.f25261b = true;
                    return getRoot();
                }
                Function1 function1Access$getOnLeave$p = FileTreeWalk.access$getOnLeave$p(FileTreeWalk.this);
                if (function1Access$getOnLeave$p != null) {
                }
                return null;
            }
        }

        /* JADX INFO: renamed from: d0.y.d$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: FileTreeWalk.kt */
        public final class C13344b extends c {

            /* JADX INFO: renamed from: b */
            public boolean f25266b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C13344b(b bVar, File file) {
                super(file);
                Intrinsics3.checkNotNullParameter(file, "rootFile");
            }

            @Override // p507d0.p591y.FileTreeWalk.c
            public File step() {
                if (this.f25266b) {
                    return null;
                }
                this.f25266b = true;
                return getRoot();
            }
        }

        /* JADX INFO: renamed from: d0.y.d$b$c */
        /* JADX INFO: compiled from: FileTreeWalk.kt */
        public final class c extends a {

            /* JADX INFO: renamed from: b */
            public boolean f25267b;

            /* JADX INFO: renamed from: c */
            public File[] f25268c;

            /* JADX INFO: renamed from: d */
            public int f25269d;

            /* JADX INFO: renamed from: e */
            public final /* synthetic */ b f25270e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(b bVar, File file) {
                super(file);
                Intrinsics3.checkNotNullParameter(file, "rootDir");
                this.f25270e = bVar;
            }

            /* JADX WARN: Code restructure failed: missing block: B:30:0x0085, code lost:
            
                if (r0.length == 0) goto L31;
             */
            @Override // p507d0.p591y.FileTreeWalk.c
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public File step() {
                Function2 function2Access$getOnFail$p;
                if (!this.f25267b) {
                    Function1 function1Access$getOnEnter$p = FileTreeWalk.access$getOnEnter$p(FileTreeWalk.this);
                    if (function1Access$getOnEnter$p != null && !((Boolean) function1Access$getOnEnter$p.invoke(getRoot())).booleanValue()) {
                        return null;
                    }
                    this.f25267b = true;
                    return getRoot();
                }
                File[] fileArr = this.f25268c;
                if (fileArr != null) {
                    int i = this.f25269d;
                    Intrinsics3.checkNotNull(fileArr);
                    if (i >= fileArr.length) {
                        Function1 function1Access$getOnLeave$p = FileTreeWalk.access$getOnLeave$p(FileTreeWalk.this);
                        if (function1Access$getOnLeave$p != null) {
                        }
                        return null;
                    }
                }
                if (this.f25268c == null) {
                    File[] fileArrListFiles = getRoot().listFiles();
                    this.f25268c = fileArrListFiles;
                    if (fileArrListFiles == null && (function2Access$getOnFail$p = FileTreeWalk.access$getOnFail$p(FileTreeWalk.this)) != null) {
                    }
                    File[] fileArr2 = this.f25268c;
                    if (fileArr2 != null) {
                        Intrinsics3.checkNotNull(fileArr2);
                    }
                    Function1 function1Access$getOnLeave$p2 = FileTreeWalk.access$getOnLeave$p(FileTreeWalk.this);
                    if (function1Access$getOnLeave$p2 != null) {
                    }
                    return null;
                }
                File[] fileArr3 = this.f25268c;
                Intrinsics3.checkNotNull(fileArr3);
                int i2 = this.f25269d;
                this.f25269d = i2 + 1;
                return fileArr3[i2];
            }
        }

        public b() {
            ArrayDeque<c> arrayDeque = new ArrayDeque<>();
            this.f25259l = arrayDeque;
            if (FileTreeWalk.access$getStart$p(FileTreeWalk.this).isDirectory()) {
                arrayDeque.push(m10091c(FileTreeWalk.access$getStart$p(FileTreeWalk.this)));
            } else if (FileTreeWalk.access$getStart$p(FileTreeWalk.this).isFile()) {
                arrayDeque.push(new C13344b(this, FileTreeWalk.access$getStart$p(FileTreeWalk.this)));
            } else {
                this.f25173j = 3;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v2, types: [java.io.File, java.lang.Object] */
        @Override // p507d0.p580t.AbstractIterator3
        /* JADX INFO: renamed from: a */
        public void mo10059a() {
            T tStep;
            while (true) {
                c cVarPeek = this.f25259l.peek();
                if (cVarPeek == null) {
                    tStep = 0;
                    break;
                }
                tStep = cVarPeek.step();
                if (tStep == 0) {
                    this.f25259l.pop();
                } else if (Intrinsics3.areEqual((Object) tStep, cVarPeek.getRoot()) || !tStep.isDirectory() || this.f25259l.size() >= FileTreeWalk.access$getMaxDepth$p(FileTreeWalk.this)) {
                    break;
                } else {
                    this.f25259l.push(m10091c(tStep));
                }
            }
            if (tStep == 0) {
                this.f25173j = 3;
            } else {
                this.f25174k = tStep;
                this.f25173j = 1;
            }
        }

        /* JADX INFO: renamed from: c */
        public final a m10091c(File file) {
            int iOrdinal = FileTreeWalk.access$getDirection$p(FileTreeWalk.this).ordinal();
            if (iOrdinal == 0) {
                return new c(this, file);
            }
            if (iOrdinal == 1) {
                return new a(this, file);
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: renamed from: d0.y.d$c */
    /* JADX INFO: compiled from: FileTreeWalk.kt */
    public static abstract class c {

        /* JADX INFO: renamed from: a */
        public final File f25271a;

        public c(File file) {
            Intrinsics3.checkNotNullParameter(file, "root");
            this.f25271a = file;
        }

        public final File getRoot() {
            return this.f25271a;
        }

        public abstract File step();
    }

    public FileTreeWalk(File file, FileTreeWalk2 fileTreeWalk2) {
        Intrinsics3.checkNotNullParameter(file, "start");
        Intrinsics3.checkNotNullParameter(fileTreeWalk2, "direction");
        this.f25253a = file;
        this.f25254b = fileTreeWalk2;
        this.f25255c = null;
        this.f25256d = null;
        this.f25257e = null;
        this.f25258f = Integer.MAX_VALUE;
    }

    public static final /* synthetic */ FileTreeWalk2 access$getDirection$p(FileTreeWalk fileTreeWalk) {
        return fileTreeWalk.f25254b;
    }

    public static final /* synthetic */ int access$getMaxDepth$p(FileTreeWalk fileTreeWalk) {
        return fileTreeWalk.f25258f;
    }

    public static final /* synthetic */ Function1 access$getOnEnter$p(FileTreeWalk fileTreeWalk) {
        return fileTreeWalk.f25255c;
    }

    public static final /* synthetic */ Function2 access$getOnFail$p(FileTreeWalk fileTreeWalk) {
        return fileTreeWalk.f25257e;
    }

    public static final /* synthetic */ Function1 access$getOnLeave$p(FileTreeWalk fileTreeWalk) {
        return fileTreeWalk.f25256d;
    }

    public static final /* synthetic */ File access$getStart$p(FileTreeWalk fileTreeWalk) {
        return fileTreeWalk.f25253a;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<File> iterator() {
        return new b();
    }
}
