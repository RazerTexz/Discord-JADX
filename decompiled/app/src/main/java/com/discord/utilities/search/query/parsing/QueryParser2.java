package com.discord.utilities.search.query.parsing;

import android.content.Context;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.query.node.content.ContentNode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: QueryParser.kt */
/* renamed from: com.discord.utilities.search.query.parsing.QueryParser$Companion$getContentRule$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class QueryParser2 extends Rule<Context, QueryNode, Object> {
    public final /* synthetic */ Pattern $simpleTextPattern;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueryParser2(Pattern pattern, Pattern pattern2) {
        super(pattern2);
        this.$simpleTextPattern = pattern;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<Context, Object> parse(Matcher matcher, Parser<Context, ? super QueryNode, Object> parser, Object state) {
        Intrinsics3.checkNotNullParameter(matcher, "matcher");
        Intrinsics3.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group();
        Intrinsics3.checkNotNullExpressionValue(strGroup, "matcher.group()");
        int length = strGroup.length() - 1;
        int i = 0;
        boolean z2 = false;
        while (i <= length) {
            boolean z3 = Intrinsics3.compare(strGroup.charAt(!z2 ? i : length), 32) <= 0;
            if (z2) {
                if (!z3) {
                    break;
                }
                length--;
            } else if (z3) {
                i++;
            } else {
                z2 = true;
            }
        }
        ContentNode contentNode = new ContentNode(strGroup.subSequence(i, length + 1).toString());
        Intrinsics3.checkNotNullParameter(contentNode, "node");
        return new ParseSpec<>(contentNode, state);
    }
}
