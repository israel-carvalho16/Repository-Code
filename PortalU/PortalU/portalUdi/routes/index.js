var express = require('express');
var router = express.Router();
const db = require('../DB');


/* GET home page. */
router.get('/', async function(req, res, next) {
  try {
    const result = await db.query('SELECT * FROM chamados ORDER BY id DESC');
    res.render('index', { title: 'Portal Udi', chamados: result.rows });
  } catch (err) {
    console.error(err);
    res.status(503).send('Erro ao buscar chamados');
  }
});

router.post('/abrir', async function(req, res,next) {
  const {solicitante, descricao} = req.body;
  try {
    await db.query('INSERT INTO chamados (solicitante,setor, descricao) VALUES ($1,$2,$3)', [solicitante,setor,descricao]);
    res.redirect('/');
  } catch (err) {
    console.error(err);
    res.status(503).send('Erro ao abrir chamado');
  }
});

module.exports = router;
