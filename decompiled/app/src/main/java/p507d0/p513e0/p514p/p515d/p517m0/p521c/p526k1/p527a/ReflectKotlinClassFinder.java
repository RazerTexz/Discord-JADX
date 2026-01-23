package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a;

import java.io.InputStream;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.StandardNames;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinClassFinder;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p564d0.BuiltInSerializerProtocol;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p564d0.BuiltInsResourceLoader;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.a.g, reason: use source file name */
/* JADX INFO: compiled from: ReflectKotlinClassFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectKotlinClassFinder implements KotlinClassFinder {

    /* JADX INFO: renamed from: a */
    public final ClassLoader f23018a;

    /* JADX INFO: renamed from: b */
    public final BuiltInsResourceLoader f23019b;

    public ReflectKotlinClassFinder(ClassLoader classLoader) {
        Intrinsics3.checkNotNullParameter(classLoader, "classLoader");
        this.f23018a = classLoader;
        this.f23019b = new BuiltInsResourceLoader();
    }

    /* JADX INFO: renamed from: a */
    public final KotlinClassFinder.a m9435a(String str) {
        ReflectKotlinClass2 reflectKotlinClass2Create;
        Class<?> clsTryLoadClass = ReflectJavaClassFinder2.tryLoadClass(this.f23018a, str);
        if (clsTryLoadClass == null || (reflectKotlinClass2Create = ReflectKotlinClass2.f23015a.create(clsTryLoadClass)) == null) {
            return null;
        }
        return new KotlinClassFinder.a.b(reflectKotlinClass2Create, null, 2, null);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.KotlinMetadataFinder
    public InputStream findBuiltInsData(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "packageFqName");
        if (fqName.startsWith(StandardNames.f22498k)) {
            return this.f23019b.loadResource(BuiltInSerializerProtocol.f24515m.getBuiltInsFilePath(fqName));
        }
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinClassFinder
    public KotlinClassFinder.a findKotlinClassOrContent(ClassId classId) {
        Intrinsics3.checkNotNullParameter(classId, "classId");
        return m9435a(ReflectKotlinClassFinder2.access$toRuntimeFqName(classId));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinClassFinder
    public KotlinClassFinder.a findKotlinClassOrContent(InterfaceC11574g interfaceC11574g) {
        Intrinsics3.checkNotNullParameter(interfaceC11574g, "javaClass");
        FqName fqName = interfaceC11574g.getFqName();
        String strAsString = fqName == null ? null : fqName.asString();
        if (strAsString == null) {
            return null;
        }
        return m9435a(strAsString);
    }
}
