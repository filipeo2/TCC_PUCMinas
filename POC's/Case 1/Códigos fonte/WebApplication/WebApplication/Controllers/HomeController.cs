using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using WebApplication.Models;

namespace WebApplication.Controllers
{
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;

        public HomeController(ILogger<HomeController> logger)
        {
            _logger = logger;
        }

        public async Task<IActionResult> Index()
        {
            RelatorioCovid relatorioCovid = null;
            List<ContagemDiariaCovid> contagemDiariaCovid = null;
            List<ContagemDiariaCovidFormatado> listaRetorno = new List<ContagemDiariaCovidFormatado>();
            int quantidadeDias = -11;

            //monta requisição http, executa o GET na rota e remonta a página conforme a lista de casos recebidos
            using (var httpClient = new HttpClient())
            {
                StringContent conteudoRequisicao = new StringContent(String.Empty, Encoding.UTF8, "application/json");
                try
                {
                    using (var resposta = await httpClient.GetAsync("http://localhost:8734/CovidREST/covid/2020-11-01"))
                    {
                        if (resposta.StatusCode == System.Net.HttpStatusCode.OK)
                        {

                            var conteudoResposta = resposta.Content.ReadAsStringAsync().Result;
                            if (!String.IsNullOrEmpty(conteudoResposta))
                            {

                                //converte o formato "2020-11-01T03:00:00.000+0000" vindo no JSON do Camel
                                relatorioCovid = Newtonsoft.Json.JsonConvert.DeserializeObject<RelatorioCovid>(
                                    conteudoResposta,
                                    new Newtonsoft.Json.Converters.IsoDateTimeConverter { DateTimeFormat = "yyyy-MM-ddThh:MM:ss.FFFK" });

                                //Filtrar apenas os últimos dias para a tela
                                DateTime dataLimiteConsulta = DateTime.Now.AddDays(-11);
                                contagemDiariaCovid = relatorioCovid.Covid.Where(
                                    x =>
                                    x.Data >= DateTime.Now.AddDays(quantidadeDias) &&
                                    x.Data <= DateTime.Now.AddDays(-1)).ToList();

                                //Transporta conteúdo para objeto lista no formato correto para exibição na tela (Data sem a hora)
                                ContagemDiariaCovidFormatado objContagemDiariaCovidFormatado;
                                foreach (var item in contagemDiariaCovid)
                                {
                                    objContagemDiariaCovidFormatado = new ContagemDiariaCovidFormatado();
                                    objContagemDiariaCovidFormatado.Data = item.Data.ToString("dd/MM/yyyy");
                                    objContagemDiariaCovidFormatado.Total = item.Total;
                                    listaRetorno.Add(objContagemDiariaCovidFormatado);
                                }

                                //Talvez o período em que o site seja testado não tenha casos fictícios
                                if (listaRetorno.Count == 0)
                                {
                                    ViewBag.Mensagem = $"Erro: Não foram encontrados casos para exibição. Os casos fictícios criados vão de {relatorioCovid.Covid[0].Data.ToString("dd/mm/yyyy")} a {relatorioCovid.Covid[relatorioCovid.Covid.Count - 1].Data.ToString("dd/mm/yyyy")} apenas e o período parametrizado nesta controller trás os últimos {quantidadeDias} dias";
                                }
                                else
                                {
                                    //Atualiza timestamp da consulta
                                    ViewBag.Mensagem = "* Consulta atualizada às " + DateTime.Now.ToShortTimeString();
                                }
                            }
                            else
                            {
                                ViewBag.Mensagem = "Erro: Resposta vazia vinda da requisição GET";
                            }

                        }
                        else
                        {
                            ViewBag.Mensagem = "Erro: GET: " + resposta.StatusCode;
                        }
                    }
                }
                catch (Exception e)
                {
                    ViewBag.Mensagem = "Erro" + e.Message;
                }
            }

            //Retorna o objeto List<> de dentro da model RelatorioCovid
            return View(listaRetorno);
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}
