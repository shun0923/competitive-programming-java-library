---
data:
  _extendedDependsOn:
  - icon: ':warning:'
    path: library/FastIO.java
    title: library/FastIO.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/Trie_startWith_test.java
    title: library/Trie_startWith_test.java
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n          \
    \         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\
    \  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/subprocess.py\"\
    , line 466, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\
    \  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/subprocess.py\"\
    , line 571, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "package library;\n\nimport java.util.*;\nimport java.util.function.*;\nimport\
    \ library.FastIO;\n\nfinal class TrieNode {\n\tpublic final int next[];\n\tpublic\
    \ final List<Integer> accept = new ArrayList<Integer>();\n\tpublic int cnt = 0;\n\
    \n\tpublic TrieNode(final int charSize) {\n\t\tnext = new int[charSize];\n\t\t\
    Arrays.fill(next, -1);\n\t}\n}\nfinal class Trie extends ArrayList<TrieNode> {\
    \ // P=prefix, M=numPrefix\n\tpublic final int charSize;\n\n\t// O(1)\n\tpublic\
    \ Trie() { this(26); }\n\tpublic Trie(int charSize) { this.charSize = charSize;\
    \ add(new TrieNode(charSize)); }\n\n\t// O(|P|)\n\tpublic final void add(final\
    \ String str) { add(str, get(0).cnt); }\n\tpublic final void add(final char[]\
    \ c) { add(c, get(0).cnt); }\n\tpublic final void add(final int[] a) { add(a,\
    \ get(0).cnt); }\n\tpublic final void add(final String str, final int id) { add(str,\
    \ id, 0, str.length()); }\n\tpublic final void add(final char[] c, final int id)\
    \ { add(c, id, 0, c.length); }\n\tpublic final void add(final int[] a, final int\
    \ id) { add(a, id, 0, a.length); }\n\tpublic final void add(final String str,\
    \ final int l, final int r) { add(str, get(0).cnt, l, r); }\n\tpublic final void\
    \ add(final char[] c, final int l, final int r) { add(c, get(0).cnt, l, r); }\n\
    \tpublic final void add(final int[] a, final int l, final int r) { add(a, get(0).cnt,\
    \ l, r); }\n\tpublic final void add(final String str, final int id, final int\
    \ l, final int r) { add(str.toCharArray(), id, l, r); }\n\tpublic final void add(final\
    \ char[] c, final int id, final int l, final int r) { add(FastIO.charToInt(c),\
    \ id, l, r); }\n\tpublic final void add(final int[] a, final int id, final int\
    \ l, final int r) {\n\t\tFastIO.inclusiveRangeCheck(l, a.length);\n\t\tFastIO.inclusiveRangeCheck(r,\
    \ a.length);\n\t\tFastIO.assertion(l <= r, \"l is larger than r.\");\n\t\tint\
    \ crt = 0;\n\t\tget(crt).cnt ++;\n\t\tfor(int i = l; i < r; i ++) {\n\t\t\tint\
    \ next = get(crt).next[a[i]];\n\t\t\tif(next == -1) {\n\t\t\t\tnext = size();\n\
    \t\t\t\tget(crt).next[a[i]] = next;\n\t\t\t\tadd(new TrieNode(charSize));\n\t\t\
    \t}\n\t\t\tcrt = next;\n\t\t\tget(crt).cnt ++;\n\t\t}\n\t\tget(crt).accept.add(id);\n\
    \t}\n\n\t// O(min(|S|,|P|))\n\tpublic final int search(final String str) { return\
    \ search(str, false); }\n\tpublic final int search(final char[] c) { return search(c,\
    \ false); }\n\tpublic final int search(final int[] a) { return search(a, false);\
    \ }\n\tpublic final int startWith(final String str) { return search(str, true);\
    \ }\n\tpublic final int startWith(final char[] c) { return search(c, true); }\n\
    \tpublic final int startWith(final int[] a) { return search(a, true); }\n\tpublic\
    \ final int search(final String str, final int l, final int r) { return search(str,\
    \ false, l, r); }\n\tpublic final int search(final char[] c, final int l, final\
    \ int r) { return search(c, false, l, r); }\n\tpublic final int search(final int[]\
    \ a, final int l, final int r) { return search(a, false, l, r); }\n\tpublic final\
    \ int startWith(final String str, final int l, final int r) { return search(str,\
    \ true, l, r); }\n\tpublic final int startWith(final char[] c, final int l, final\
    \ int r) { return search(c, true, l, r); }\n\tpublic final int startWith(final\
    \ int[] a, final int l, final int r) { return search(a, true, l, r); }\n\tpublic\
    \ final int search(final String str, final boolean prefix) { return search(str,\
    \ prefix, 0, str.length()); }\n\tpublic final int search(final char[] c, final\
    \ boolean prefix) { return search(c, prefix, 0, c.length); }\n\tpublic final int\
    \ search(final int[] a, final boolean prefix) { return search(a, prefix, 0, a.length);\
    \ }\n\tpublic final int search(final String str, final boolean prefix, final int\
    \ l, final int r) { return search(str.toCharArray(), prefix, l, r); }\n\tpublic\
    \ final int search(final char[] c, final boolean prefix, final int l, final int\
    \ r) { return search(FastIO.charToInt(c), prefix, l, r); }\n\tpublic final int\
    \ search(final int[] a, final boolean prefix, final int l, final int r) {\n\t\t\
    FastIO.inclusiveRangeCheck(l, a.length);\n\t\tFastIO.inclusiveRangeCheck(r, a.length);\n\
    \t\tFastIO.assertion(l <= r, \"l is larger than r.\");\n\t\tint crt = 0;\n\t\t\
    for(int i = l; i < r; i ++) {\n\t\t\tcrt = get(crt).next[a[i]];\n\t\t\tif(crt\
    \ == -1) return 0;\n\t\t}\n\t\treturn prefix ? get(crt).cnt : get(crt).accept.size();\n\
    \t}\n\n\t// O(min(|S|,|P|,M))\n\tpublic final List<Integer> prefix(final String\
    \ str) { return prefix(str, 0, str.length()); }\n\tpublic final List<Integer>\
    \ prefix(final char[] c) { return prefix(c, 0, c.length); }\n\tpublic final List<Integer>\
    \ prefix(final int[] a) { return prefix(a, 0, a.length); }\n\tpublic final List<Integer>\
    \ prefix(final String str, final int l, final int r) { return prefix(str.toCharArray(),\
    \ l, r); }\n\tpublic final List<Integer> prefix(final char[] c, final int l, final\
    \ int r) { return prefix(FastIO.charToInt(c), l, r); }\n\tpublic final List<Integer>\
    \ prefix(final int[] a, final int l, final int r) {\n\t\tFastIO.inclusiveRangeCheck(l,\
    \ a.length);\n\t\tFastIO.inclusiveRangeCheck(r, a.length);\n\t\tFastIO.assertion(l\
    \ <= r, \"l is larger than r.\");\n\t\tList<Integer> prefix = new ArrayList<Integer>();\n\
    \t\tint crt = 0;\n\t\tfor(int i = l; i <= r; i ++) {\n\t\t\tfor(int ele : get(crt).accept)\
    \ prefix.add(ele);\n\t\t\tif(i == r) break;\n\t\t\tcrt = get(crt).next[a[i]];\n\
    \t\t\tif(crt == -1) break;\n\t\t}\n\t\treturn prefix;\n\t}\n\n\t// O(min(|S|,|P|)+M)\n\
    \tpublic final void query(final String str, final IntConsumer f) { query(str,\
    \ f, 0, str.length()); }\n\tpublic final void query(final char[] c, final IntConsumer\
    \ f) { query(c, f, 0, c.length); }\n\tpublic final void query(final int[] a, final\
    \ IntConsumer f) { query(a, f, 0, a.length); }\n\tpublic final void query(final\
    \ String str, final IntConsumer f, final int l, final int r) { query(str.toCharArray(),\
    \ f, l, r); }\n\tpublic final void query(final char[] c, final IntConsumer f,\
    \ final int l, final int r) { query(FastIO.charToInt(c), f, l, r); }\n\tpublic\
    \ final void query(final int[] a, final IntConsumer f, final int l, final int\
    \ r) {\n\t\tint crt = 0;\n\t\tfor(int i = l; i <= r; i ++) {\n\t\t\tfor(int ele\
    \ : get(crt).accept) f.accept(ele);\n\t\t\tif(i == r) break;\n\t\t\tcrt = get(crt).next[a[i]];\n\
    \t\t\tif(crt == -1) break;\n\t\t}\n\t}\n\t// O(min(|S|,|P|)+M)\n\tpublic final\
    \ long query(final String str, final long e, final LongBinaryOperator f) { return\
    \ query(str, e, f, 0, str.length()); }\n\tpublic final long query(final char[]\
    \ c, final long e, final LongBinaryOperator f) { return query(c, e, f, 0, c.length);\
    \ }\n\tpublic final long query(final int[] a, final long e, final LongBinaryOperator\
    \ f) { return query(a, e, f, 0, a.length); }\n\tpublic final long query(final\
    \ String str, final long e, final LongBinaryOperator f, final int l, final int\
    \ r) { return query(str.toCharArray(), e, f, l, r); }\n\tpublic final long query(final\
    \ char[] c, final long e, final LongBinaryOperator f, final int l, final int r)\
    \ { return query(FastIO.charToInt(c), e, f, l, r); }\n\tpublic final long query(final\
    \ int[] a, final long e, final LongBinaryOperator f, final int l, final int r)\
    \ {\n\t\tint crt = 0;\n\t\tlong ans = e;\n\t\tfor(int i = l; i <= r; i ++) {\n\
    \t\t\tfor(int ele : get(crt).accept) ans = f.applyAsLong(ans, ele);\n\t\t\tif(i\
    \ == r) break;\n\t\t\tcrt = get(crt).next[a[i]];\n\t\t\tif(crt != -1) break;\n\
    \t\t}\n\t\treturn ans;\n\t}\n\n\tpublic final int count() { return get(0).cnt;\
    \ } // O(1)\n}"
  dependsOn:
  - library/FastIO.java
  isVerificationFile: false
  path: library/Trie.java
  requiredBy: []
  timestamp: '2023-03-23 19:06:36+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/Trie_startWith_test.java
documentation_of: library/Trie.java
layout: document
redirect_from:
- /library/library/Trie.java
- /library/library/Trie.java.html
title: library/Trie.java
---