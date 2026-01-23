package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p564d0;

import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.BuiltInsPackageFragment;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11688m;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p546y.BuiltInsBinaryVersion;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.DeserializedPackageFragmentImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p591y.Closeable;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.d0.c, reason: use source file name */
/* JADX INFO: compiled from: BuiltInsPackageFragmentImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class BuiltInsPackageFragmentImpl extends DeserializedPackageFragmentImpl implements BuiltInsPackageFragment {

    /* JADX INFO: renamed from: v */
    public static final a f24517v = new a(null);

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.d0.c$a */
    /* JADX INFO: compiled from: BuiltInsPackageFragmentImpl.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final BuiltInsPackageFragmentImpl create(FqName fqName, StorageManager storageManager, ModuleDescriptor2 moduleDescriptor2, InputStream inputStream, boolean z2) throws IOException {
            Intrinsics3.checkNotNullParameter(fqName, "fqName");
            Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
            Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
            Intrinsics3.checkNotNullParameter(inputStream, "inputStream");
            try {
                BuiltInsBinaryVersion from = BuiltInsBinaryVersion.f23998f.readFrom(inputStream);
                if (from == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("version");
                    throw null;
                }
                if (from.isCompatible()) {
                    C11688m from2 = C11688m.parseFrom(inputStream, BuiltInSerializerProtocol.f24515m.getExtensionRegistry());
                    Closeable.closeFinally(inputStream, null);
                    Intrinsics3.checkNotNullExpressionValue(from2, "proto");
                    return new BuiltInsPackageFragmentImpl(fqName, storageManager, moduleDescriptor2, from2, from, z2, null);
                }
                throw new UnsupportedOperationException("Kotlin built-in definition format version is not supported: expected " + BuiltInsBinaryVersion.f23999g + ", actual " + from + ". Please update Kotlin");
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    Closeable.closeFinally(inputStream, th);
                    throw th2;
                }
            }
        }
    }

    public BuiltInsPackageFragmentImpl(FqName fqName, StorageManager storageManager, ModuleDescriptor2 moduleDescriptor2, C11688m c11688m, BuiltInsBinaryVersion builtInsBinaryVersion, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        super(fqName, storageManager, moduleDescriptor2, c11688m, builtInsBinaryVersion, null);
    }
}
