package b.a.k.f;

import android.text.SpannableStringBuilder;
import android.webkit.URLUtil;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.simpleast.core.node.Node;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;

/* compiled from: HookNode.kt */
/* loaded from: classes.dex */
public final class c extends Node.a<RenderContext> {
    public final String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String str) {
        super(new Node[0]);
        m.checkNotNullParameter(str, "key");
        this.a = str;
    }

    @Override // com.discord.simpleast.core.node.Node.a, com.discord.simpleast.core.node.Node
    public void render(SpannableStringBuilder spannableStringBuilder, Object obj) {
        List<Object> list;
        RenderContext renderContext = (RenderContext) obj;
        m.checkNotNullParameter(spannableStringBuilder, "builder");
        m.checkNotNullParameter(renderContext, "renderContext");
        Hook hook = renderContext.hooks.get(this.a);
        int length = spannableStringBuilder.length();
        super.render(spannableStringBuilder, renderContext);
        Hook.a aVar = null;
        CharSequence charSequence = hook != null ? hook.replacementText : null;
        if (charSequence != null) {
            spannableStringBuilder.replace(length, spannableStringBuilder.length(), charSequence);
        }
        if (hook != null && (list = hook.styles) != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                spannableStringBuilder.setSpan(it.next(), length, spannableStringBuilder.length(), 33);
            }
        }
        Hook.a aVar2 = hook != null ? hook.clickHandler : null;
        if (aVar2 != null) {
            aVar = aVar2;
        } else if (URLUtil.isValidUrl(this.a)) {
            b.a.k.a aVar3 = b.a.k.a.d;
            aVar = new Hook.a(b.a.k.a.f245b.invoke(), b.a.k.a.c);
        }
        if (aVar != null) {
            Integer numInvoke = aVar.a;
            if (numInvoke == null) {
                b.a.k.a aVar4 = b.a.k.a.d;
                numInvoke = b.a.k.a.f245b.invoke();
            }
            spannableStringBuilder.setSpan(new b.a.k.e.a(new b(this, aVar), numInvoke), length, spannableStringBuilder.length(), 33);
            renderContext.hasClickables = true;
        }
    }
}
