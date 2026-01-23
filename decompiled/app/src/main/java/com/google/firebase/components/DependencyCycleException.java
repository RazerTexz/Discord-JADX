package com.google.firebase.components;

import java.util.Arrays;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p361c.p368l.Component4;

/* JADX INFO: loaded from: classes3.dex */
public class DependencyCycleException extends DependencyException {
    private final List<Component4<?>> componentsInCycle;

    /* JADX WARN: Illegal instructions before constructor call */
    public DependencyCycleException(List<Component4<?>> list) {
        StringBuilder sbM833U = outline.m833U("Dependency cycle detected: ");
        sbM833U.append(Arrays.toString(list.toArray()));
        super(sbM833U.toString());
        this.componentsInCycle = list;
    }
}
