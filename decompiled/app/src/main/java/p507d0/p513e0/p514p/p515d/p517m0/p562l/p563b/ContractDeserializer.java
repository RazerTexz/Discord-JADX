package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import kotlin.Tuples2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11684i;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.TypeTable;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ContractDeserializer.kt */
/* renamed from: d0.e0.p.d.m0.l.b.i, reason: use source file name */
/* loaded from: classes3.dex */
public interface ContractDeserializer {

    /* renamed from: a */
    public static final a f24635a = a.f24636a;

    /* compiled from: ContractDeserializer.kt */
    /* renamed from: d0.e0.p.d.m0.l.b.i$a */
    public static final class a {

        /* renamed from: a */
        public static final /* synthetic */ a f24636a = new a();

        /* renamed from: b */
        public static final ContractDeserializer f24637b = new C13334a();

        /* compiled from: ContractDeserializer.kt */
        /* renamed from: d0.e0.p.d.m0.l.b.i$a$a, reason: collision with other inner class name */
        public static final class C13334a implements ContractDeserializer {
            @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.ContractDeserializer
            public Tuples2 deserializeContractFromFunction(C11684i c11684i, FunctionDescriptor functionDescriptor, TypeTable typeTable, TypeDeserializer typeDeserializer) {
                Intrinsics3.checkNotNullParameter(c11684i, "proto");
                Intrinsics3.checkNotNullParameter(functionDescriptor, "ownerFunction");
                Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
                Intrinsics3.checkNotNullParameter(typeDeserializer, "typeDeserializer");
                return null;
            }
        }

        public final ContractDeserializer getDEFAULT() {
            return f24637b;
        }
    }

    Tuples2<CallableDescriptor.a<?>, Object> deserializeContractFromFunction(C11684i c11684i, FunctionDescriptor functionDescriptor, TypeTable typeTable, TypeDeserializer typeDeserializer);
}
