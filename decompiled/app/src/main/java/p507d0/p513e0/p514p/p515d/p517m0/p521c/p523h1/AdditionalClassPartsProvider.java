package p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Collection;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassConstructorDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SimpleFunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: AdditionalClassPartsProvider.kt */
/* renamed from: d0.e0.p.d.m0.c.h1.a, reason: use source file name */
/* loaded from: classes3.dex */
public interface AdditionalClassPartsProvider {

    /* compiled from: AdditionalClassPartsProvider.kt */
    /* renamed from: d0.e0.p.d.m0.c.h1.a$a */
    public static final class a implements AdditionalClassPartsProvider {

        /* renamed from: a */
        public static final a f22796a = new a();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.AdditionalClassPartsProvider
        public Collection<ClassConstructorDescriptor> getConstructors(ClassDescriptor classDescriptor) {
            Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
            return Collections2.emptyList();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.AdditionalClassPartsProvider
        public Collection<SimpleFunctionDescriptor> getFunctions(Name name, ClassDescriptor classDescriptor) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
            return Collections2.emptyList();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.AdditionalClassPartsProvider
        public Collection<Name> getFunctionsNames(ClassDescriptor classDescriptor) {
            Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
            return Collections2.emptyList();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.AdditionalClassPartsProvider
        public Collection<KotlinType> getSupertypes(ClassDescriptor classDescriptor) {
            Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
            return Collections2.emptyList();
        }
    }

    Collection<ClassConstructorDescriptor> getConstructors(ClassDescriptor classDescriptor);

    Collection<SimpleFunctionDescriptor> getFunctions(Name name, ClassDescriptor classDescriptor);

    Collection<Name> getFunctionsNames(ClassDescriptor classDescriptor);

    Collection<KotlinType> getSupertypes(ClassDescriptor classDescriptor);
}
