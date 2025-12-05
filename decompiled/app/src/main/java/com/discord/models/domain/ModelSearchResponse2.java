package com.discord.models.domain;

import com.discord.api.message.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import p507d0.p580t.Collections2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Lambda;

/* compiled from: ModelSearchResponse.kt */
/* renamed from: com.discord.models.domain.ModelSearchResponse$hits$2, reason: use source file name */
/* loaded from: classes.dex */
public final class ModelSearchResponse2 extends Lambda implements Function0<List<? extends Message>> {
    public final /* synthetic */ ModelSearchResponse this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelSearchResponse2(ModelSearchResponse modelSearchResponse) {
        super(0);
        this.this$0 = modelSearchResponse;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends Message> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends Message> invoke2() {
        Object next;
        List<List<Message>> messages = this.this$0.getMessages();
        if (messages != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = messages.iterator();
            while (it.hasNext()) {
                Iterator it2 = ((List) it.next()).iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                    Boolean hit = ((Message) next).getHit();
                    if (hit != null ? hit.booleanValue() : false) {
                        break;
                    }
                }
                Message message = (Message) next;
                if (message != null) {
                    arrayList.add(message);
                }
            }
            List<? extends Message> list = _Collections.toList(arrayList);
            if (list != null) {
                return list;
            }
        }
        return Collections2.emptyList();
    }
}
