package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.StandardNames;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.b1, reason: use source file name */
/* JADX INFO: compiled from: TypeSubstitutor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TypeSubstitutor implements Function1<FqName, Boolean> {
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FqName fqName) {
        return invoke2(fqName);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public Boolean invoke2(FqName fqName) {
        if (fqName != null) {
            return Boolean.valueOf(!fqName.equals(StandardNames.a.f22510G));
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", ModelAuditLogEntry.CHANGE_KEY_NAME, "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor$1", "invoke"));
    }
}
