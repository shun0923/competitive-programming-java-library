---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/Mod.java
    title: library/Mod.java
  - icon: ':x:'
    path: library/Pair.java
    title: library/Pair.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  - icon: ':x:'
    path: library/TemplateSegmentTree.java
    title: library/TemplateSegmentTree.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
  attributes:
    PROBLEM: https://judge.yosupo.jp/problem/point_set_range_composite
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
  code: "// verification-helper: PROBLEM https://judge.yosupo.jp/problem/point_set_range_composite\n\
    \npackage library;\n\nimport library.Solver;\nimport library.Pair;\nimport library.Mod;\n\
    import library.TemplateSegmentTree;\n\npublic class TemplateSegmentTree_composite_test\
    \ extends Solver {\n\tpublic static void main(final String[] args) { main(args,\
    \ new TemplateSegmentTree_composite_test()); }\n\n\tpublic void solve() {\n\t\t\
    Mod md = Mod998.md;\n\t\tint n = ni();\n\t\tint q = ni();\n\t\tPair.LL f[] = Pair.npll(n);\n\
    \t\tTemplateSegmentTree<Pair.LL> st = new TemplateSegmentTree<>(f,\n\t\t\t() ->\
    \ new Pair.LL(1, 0),\n\t\t\t(ele1, ele2) -> new Pair.LL(md.mul(ele1.a, ele2.a),\
    \ md.mod(ele2.a * ele1.b + ele2.b)));\n\t\tfor(int i = 0; i < q; i ++) {\n\t\t\
    \tif(ni() == 0) st.set(ni(), Pair.npll());\n\t\t\telse {\n\t\t\t\tPair.LL p =\
    \ st.find(ni(), ni());\n\t\t\t\tprtln(md.mod(p.a * nl() + p.b));\n\t\t\t}\n\t\t\
    }\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/Pair.java
  - library/Mod.java
  - library/TemplateSegmentTree.java
  isVerificationFile: true
  path: library/TemplateSegmentTree_composite_test.java
  requiredBy: []
  timestamp: '2023-03-23 19:06:36+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: library/TemplateSegmentTree_composite_test.java
layout: document
redirect_from:
- /verify/library/TemplateSegmentTree_composite_test.java
- /verify/library/TemplateSegmentTree_composite_test.java.html
title: library/TemplateSegmentTree_composite_test.java
---