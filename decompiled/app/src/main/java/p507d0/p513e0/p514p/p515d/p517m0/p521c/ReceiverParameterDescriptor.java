package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p.ReceiverValue;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitutor2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.q0, reason: use source file name */
/* JADX INFO: compiled from: ReceiverParameterDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public interface ReceiverParameterDescriptor extends ParameterDescriptor {
    ReceiverValue getValue();

    ReceiverParameterDescriptor substitute(TypeSubstitutor2 typeSubstitutor2);
}
